package com.learn.auth.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Object data;

    public AppException(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = message;
    }

    public AppException(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
