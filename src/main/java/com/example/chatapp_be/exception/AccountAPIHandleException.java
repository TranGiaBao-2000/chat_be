package com.example.chatapp_be.exception;


import com.example.chatapp_be.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // bắt lỗi và response về cho ng dùng
public class AccountAPIHandleException {

    @ExceptionHandler(InvalidToken.class)
    public ResponseEntity invalidToken(InvalidToken invalidToken){
        Response response = new Response(400, invalidToken.getMessage(), null);
        return ResponseEntity.ok(response);
    }

}
