package com.arm.mbed.cloud.sdk.accountmanagement.adapters;

import java.util.List;

import com.arm.mbed.cloud.sdk.annotations.Preamble;
import com.arm.mbed.cloud.sdk.common.ListResponse;
import com.arm.mbed.cloud.sdk.common.Order;

@Preamble(description = "Generic list adapter")
public class GenericListAdapter {
	public interface Mapper<T, U> {
		<T, U> T map(U toBeMapped);
	}

	public interface RespList<U> {
		Boolean getHasMore();

		Integer getTotalCount();

		String getAfter();

		Integer getLimit();

		String getOrder();

		List<U> getData();
	}

	public static <T, U> ListResponse<T> mapList(RespList<U> respList, Mapper<T, U> mapper) {
		if (respList == null || mapper == null) {
			return null;
		}
		ListResponse<T> responseList = new ListResponse<T>(TranslationUtils.toBool(respList.getHasMore(), false),
				TranslationUtils.toInt(respList.getTotalCount()), respList.getAfter(),
				TranslationUtils.toInt(respList.getLimit()), Order.getOrder(respList.getOrder()));
		if (respList.getData() == null || respList.getData().isEmpty()) {
			return responseList;
		}
		for (U resp : respList.getData()) {
			responseList.addData(mapper.map(resp));
		}
		return responseList;

	}
}
