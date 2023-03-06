package com.example.chatapp_be.controller;


import com.example.chatapp_be.dto.AccountDTO;
import com.example.chatapp_be.dto.Response;
import com.example.chatapp_be.dto.Token;
import com.example.chatapp_be.enity.Account;
import com.example.chatapp_be.exception.BadRequest;
import com.example.chatapp_be.repository.AccountRepository;
import com.example.chatapp_be.service.VerifyTokenGoogle;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/login-gg")
    public ResponseEntity loginGoogle(@RequestBody Token token){
        // input: token

        // process: check coi có account trong hệ thống chưa
        AccountDTO account = verifyTokenGoogle.verifyToken(token.getId());

        // check tồn tại chưa?
        Account acc = accountRepository.findAccountByEmail(account.getEmail());
        if(acc == null){
            // account da ton tai
            throw new BadRequest("Account does not exist!");
        }

        Response<Account> response  = new Response<Account>(200, "Login success", acc);
        // response: kết qủa
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register-gg")
    public ResponseEntity registerGoogle(@RequestBody Token token){
        // input: token

        // lấy thông tin từ trong token
        AccountDTO account = verifyTokenGoogle.verifyToken(token.getId());

        // check tồn tại chưa?
        Account acc = accountRepository.findAccountByEmail(account.getEmail());
        Account newAccount;
        if(acc == null){
            // chua co account
            acc = new Account();
            acc.setEmail(account.getEmail());
            acc.setPicture(account.getPicture());
            acc.setFullName(account.getFullName());
            newAccount = accountRepository.save(acc);
        }else{
            // account da ton tai
            throw new BadRequest("Account already exist!");
        }

        Response<Account> response  = new Response<Account>(200, "Register success", newAccount);
        // response: kết qủa
        return ResponseEntity.ok(response);
    }


}