package com.example.chatapp_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    int code;
    String message;
    T data;
}
