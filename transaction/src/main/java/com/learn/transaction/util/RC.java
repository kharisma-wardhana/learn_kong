package com.learn.transaction.util;

public abstract class RC {
    private RC() {}

    public static final int SUCCESS_CODE = 200;
    public static final int SUCCESS_CREATED_CODE = 201;
    public static final int SUCCESS_NO_CONTENT_CODE = 204;

    public static final int BAD_REQUEST_CODE = 400;
    public static final int UNAUTHORIZED_CODE = 401;
    public static final int FORBIDDEN_CODE = 403;
    public static final int NOT_FOUND_CODE = 404;
    public static final int METHOD_NOT_ALLOWED_CODE = 405;
    public static final int LOGIN_TIMEOUT_CODE = 440;
    public static final int INVALID_TOKEN_CODE = 498;
    public static final int REQUIRED_TOKEN_CODE = 499;

    public static final int INTERNAL_ERROR_CODE = 500;


    public static final String SUCCESS = "Success";
    public static final String FAILED = "Failed";
}
