package com.example.chatapp_be.dto.resquest;

import lombok.Data;

@Data
public class SignUpRequest {
    String email;
    String fullName;
    String picture;
    String username;
    String password;
}
