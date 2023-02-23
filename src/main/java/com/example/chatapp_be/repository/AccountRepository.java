package com.example.chatapp_be.repository;

import com.example.chatapp_be.enity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
