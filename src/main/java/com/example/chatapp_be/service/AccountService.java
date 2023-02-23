package com.example.chatapp_be.service;

import com.example.chatapp_be.dto.resquest.SignUpRequest;
import com.example.chatapp_be.enity.Account;
import com.example.chatapp_be.mapper.AccountMapper;
import com.example.chatapp_be.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    public Account signUp(SignUpRequest signUpRequest){
        Account account = accountMapper.convertToEntity(signUpRequest);
        return accountRepository.save(account);
    }

}
