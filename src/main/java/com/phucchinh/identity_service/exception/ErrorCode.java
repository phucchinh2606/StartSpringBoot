package com.phucchinh.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error!"),
    INVALID_PASSWORD(1004,"Password must be at least 8 characters"),
    USER_EXISTED(1002,"User existed!"),
    INVALID_KEY(1001,"Invalid message key"),
    USERNAME_INVALID(1003,"Username must be at least 3 characters"),
    USER_NOT_EXISTED(1005,"User NOT existed!"),
    UNAUTHENTICATED(1006,"Unauthenticated!")
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
