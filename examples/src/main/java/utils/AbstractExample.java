package utils;

import org.junit.runner.RunWith;

@RunWith(ExampleRunner.class)
public abstract class AbstractExample {

    public void log(String message, Object object) {
        String objectStr = (object == null) ? "Null Object" : object.toString();
        ExampleLogger.log(((message == null) ? "" : message + ": ") + objectStr);
    }

    public void log(Object obj) {
        ExampleLogger.log(obj);
    }

    public void log(String message) {
        ExampleLogger.log(message == null ? "" : message);
    }

    public void logError(String message, Object object) {
        String objectStr = (object == null) ? "Null Object" : object.toString();
        ExampleLogger.logError((((message == null) ? "" : message + ": ")) + objectStr);
    }

}
