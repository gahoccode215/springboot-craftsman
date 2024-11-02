package com.gahoccode.identity_service.exception;

import com.gahoccode.identity_service.dto.request.APIResponse;
import com.nimbusds.jose.KeyLengthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = KeyLengthException.class)
    ResponseEntity<APIResponse> handlingKeyLengthException(KeyLengthException exception){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(ErrorCode.KEY_LENGTH.getCode());
        apiResponse.setMessage(ErrorCode.KEY_LENGTH.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<APIResponse> handlingRuntimeException(RuntimeException exception){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<APIResponse> handlingValidation(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<APIResponse> handlingValidation(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }catch (IllegalArgumentException e){

        }
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
