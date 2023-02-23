package com.example.chatapp_be.enity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    // code first
    // code => generate ra database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String email;
    String fullName;
    String picture;
    String username;
    String password;

}
