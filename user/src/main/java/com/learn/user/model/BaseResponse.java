package com.learn.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse {
    private int code;
    private String message;
    private Object data;
}
