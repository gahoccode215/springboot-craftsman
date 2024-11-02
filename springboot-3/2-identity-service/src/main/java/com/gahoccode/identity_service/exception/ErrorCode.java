package com.gahoccode.identity_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error."),
    INVALID_KEY(1001, "Uncategorized error."),
    USER_EXISTED(1002, "User existed."),
    USERNAME_INVALID(1003, "Username must be at least 3 characters."),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters."),
    USER_NOT_EXISTED(1005, "User existed."),
    UNAUTHENTICATED(1006, "Unauthenticated."),
    KEY_LENGTH(1007, "The secret length must be at least 256 bits.")
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
