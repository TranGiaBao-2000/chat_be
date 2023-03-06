package com.example.chatapp_be.repository;

import com.example.chatapp_be.enity.Account;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByEmail(String email);

}
