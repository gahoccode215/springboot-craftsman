package com.gahoccode.identity_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error.", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed.", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters.", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "Password must be at least {min} characters.", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User existed.", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated.", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission.", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    KEY_LENGTH(1009, "The secret length must be at least 256 bits.", HttpStatus.BAD_REQUEST);
    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
