package com.arm.mbed.cloud.sdk;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ConnectionOptions;
import com.arm.mbed.cloud.sdk.testutils.APICallException;
import com.arm.mbed.cloud.sdk.testutils.APICaller;
import com.arm.mbed.cloud.sdk.testutils.APIMappingGenerator;
import com.arm.mbed.cloud.sdk.testutils.CaseConvertor;
import com.arm.mbed.cloud.sdk.testutils.SDK;
import com.arm.mbed.cloud.sdk.testutils.UnknownAPIException;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

@Preamble(description = "Test system server part in charge of carrying out a mapping of the APIs present in the SDK and invoking them when requested by the client")
public class TestServer {

	private static final String CONTENT_TYPE_HEADER = "content-type";
	private static final String APPLICATION_JSON = "application/json";
	private static final String ENVVAR_MBED_CLOUD_HOST = "MBED_CLOUD_HOST";
	private static final String ENVVAR_MBED_CLOUD_API_KEY = "MBED_CLOUD_API_KEY";
	private static final String PARAM_METHOD = "method";
	private static final String PARAM_MODULE = "module";
	private static final boolean CONSOLE_COLOURING = (System.getenv("CONSOLE_COLOURING") == null) ? false : true;
	private static final String LOGGER_DELEGATE_FACTORY_CLASS_NAME_PROPERTY = "vertx.logger-delegate-factory-class-name";
	private static final String LOGGER_DELEGATE_FACTORY_CLASS_NAME = "io.vertx.core.logging.SLF4JLogDelegateFactory";
	static {
		System.setProperty(LOGGER_DELEGATE_FACTORY_CLASS_NAME_PROPERTY, LOGGER_DELEGATE_FACTORY_CLASS_NAME);
	}
	private final int port = 5000;
	private HttpServer server;
	private Router router;
	private final Logger testLogger = LoggerFactory.getLogger("Java SDK Test server");
	private static final String LOG_PREFIX = "  \u001B[34mtestserver\u001B[0m ";
	private SDK sdk;
	private ConnectionOptions config;

	public void start() {
		sdk = null;
		config = null;
		if (server == null) {
			Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
			server = vertx.createHttpServer();
			router = Router.router(vertx);
		}
		retrieveConfig();
		if (config == null || config.isApiKeyEmpty()) {
			logInfo("Unable to find " + String.valueOf(ENVVAR_MBED_CLOUD_API_KEY) + " environment variable");
			return;
		}
		defineInitialisationRoute();
		defineModuleMethodTestRoute();
		logInfo("Starting Java SDK test server on port " + String.valueOf(port) + "...");
		server.requestHandler(router::accept).listen(port);
	}

	private void defineInitialisationRoute() {
		Route route = router.route(HttpMethod.GET, "/_init").produces(APPLICATION_JSON);
		route.blockingHandler(routingContext -> {

			logInfo("Initialising Java SDK modules... (" + new Date().toString() + ")");
			sdk = APIMappingGenerator.getSDK();
			JsonObject emptyResponse = new JsonObject();
			setResponse(routingContext).end(emptyResponse.encode());
		});
	}

	private void defineModuleMethodTestRoute() {
		Route route = router.route(HttpMethod.GET, "/:" + PARAM_MODULE + "/:" + PARAM_METHOD + "*")
				.produces(APPLICATION_JSON);
		route.blockingHandler(routingContext -> {
			if (sdk == null) {
				sendError(setResponse(routingContext), null, "Modules have not been initialised");
				return;
			}

			HttpServerRequest request = routingContext.request();
			String module = request.getParam(PARAM_MODULE);
			String method = request.getParam(PARAM_METHOD);
			Map<String, String> params = retrieveQueryParameters(request);
			logInfo("TEST http://localhost:" + String.valueOf(port) + request.uri() + " at " + new Date().toString());
			APICaller caller = new APICaller(sdk, config);
			try {
				logInfo("CALLING " + String.valueOf(method) + " on " + String.valueOf(module) + " USING "
						+ String.valueOf(params.toString()));
				Object result = caller.callAPI(CaseConvertor.convertSnakeToCamel(module, true),
						CaseConvertor.convertSnakeToCamel(method, false), params);
				setResponse(routingContext).end(convertResultToJson(result));
			} catch (UnknownAPIException | APICallException e) {
				sendError(setResponse(routingContext), null, e.getMessage());
			}
		});
	}

	private HttpServerResponse setResponse(RoutingContext routingContext) {
		return routingContext.response().putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON);
	}

	private void retrieveConfig() {
		config = new ConnectionOptions(System.getenv(ENVVAR_MBED_CLOUD_API_KEY), System.getenv(ENVVAR_MBED_CLOUD_HOST));

	}

	private String convertResultToJson(Object result) {
		return (result == null) ? "{}" : reformatResultJson(JsonObject.mapFrom(result)).encode();
	}

	/*
	 * Change result JSON entries to be snake case as expected by the test
	 * system
	 */
	private JsonObject reformatResultJson(JsonObject result) {
		return (result == null) ? new JsonObject() : new JsonObject(reformatResultJsonMap(result.getMap()));
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> reformatResultJsonMap(Map<String, Object> resultMap) {
		Map<String, Object> formattedResult = new LinkedHashMap<String, Object>();
		for (Entry<String, Object> entry : resultMap.entrySet()) {
			formattedResult.put(CaseConvertor.convertCamelToSnake(entry.getKey()),
					(entry.getValue() instanceof Map<?, ?>)
							? reformatResultJsonMap((Map<String, Object>) entry.getValue()) : entry.getValue());
		}
		return formattedResult;
	}

	private Map<String, String> retrieveQueryParameters(HttpServerRequest request) {
		MultiMap map = request.params();
		Map<String, String> params = new LinkedHashMap<String, String>();
		for (Entry<String, String> element : map.entries()) {
			if (!element.getKey().equalsIgnoreCase(PARAM_MODULE) && !element.getKey().equalsIgnoreCase(PARAM_METHOD)) {
				params.put(element.getKey(), element.getValue());
			}
		}
		return params;
	}

	private void logInfo(String message) {
		testLogger.info((CONSOLE_COLOURING) ? LOG_PREFIX + message : message);
	}

	private void sendError(HttpServerResponse res, Integer errorCode, String errorMessage) {
		int statusCode = (errorCode == null) ? 500 : errorCode;
		JsonObject responseMessage = new JsonObject();
		responseMessage.put("message", errorMessage);
		logInfo(String.valueOf(statusCode) + ": " + String.valueOf(errorMessage));
		res.setStatusCode(statusCode).putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON).end(responseMessage.encode());
	}

	public static void main(String[] args) {
		TestServer server = new TestServer();
		server.start();
	}

}
