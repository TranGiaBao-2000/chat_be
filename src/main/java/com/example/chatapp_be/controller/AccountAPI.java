package com.example.chatapp_be.controller;


import com.example.chatapp_be.dto.Account;
import com.example.chatapp_be.dto.Response;
import com.example.chatapp_be.dto.Token;
import com.example.chatapp_be.service.VerifyTokenGoogle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController // anotation
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500", "http://giabao.com"})
public class AccountAPI {

    VerifyTokenGoogle verifyTokenGoogle = new VerifyTokenGoogle();

    @PostMapping("/login-gg")
    public ResponseEntity loginGoogle(@RequestBody Token token){
        // input: token

        // process: check coi có account trong hệ thống chưa
        Account account = verifyTokenGoogle.verifyToken(token.getId());

        Response<Account> response  = new Response<Account>(200, "Login success", account);
        // response: kết qủa
        return ResponseEntity.ok(response);
    }


}
