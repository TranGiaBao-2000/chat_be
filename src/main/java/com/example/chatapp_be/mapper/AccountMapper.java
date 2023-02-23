package com.example.chatapp_be.mapper;

import com.example.chatapp_be.dto.resquest.SignUpRequest;
import com.example.chatapp_be.enity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account convertToEntity(SignUpRequest signUpRequest){
        Account account = new Account();
        account.setPicture(signUpRequest.getPicture());
        account.setUsername(signUpRequest.getUsername());
        account.setPassword(signUpRequest.getPassword());
        account.setFullName(signUpRequest.getFullName());
        account.setEmail(signUpRequest.getEmail());
        return account;
    }

}
