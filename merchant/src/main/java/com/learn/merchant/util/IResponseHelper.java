package com.learn.merchant.util;

import com.learn.merchant.model.BaseResponse;

public interface IResponseHelper {
    default BaseResponse successWithData(Object data) {
       return BaseResponse.builder()
               .code(RC.SUCCESS_CODE)
               .message(RC.SUCCESS)
               .data(data)
               .build();
    }

    default BaseResponse successWithoutData() {
        return BaseResponse.builder()
                .code(RC.SUCCESS_NO_CONTENT_CODE)
                .message(RC.SUCCESS)
                .build();
    }

    default BaseResponse failedBadRequest(Object data) {
        return BaseResponse.builder()
                .code(RC.BAD_REQUEST_CODE)
                .message(RC.FAILED)
                .data(data)
                .build();
    }
}
