package com.example.chatapp_be.repository;

import com.example.chatapp_be.enity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByEmail(String email);

    List<Account> findAccountsByEmailContainingOrFullNameContaining(String email, String fullName);

}
