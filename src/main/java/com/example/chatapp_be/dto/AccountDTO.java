package com.example.chatapp_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    long id;
    String email;
    String fullName;
    String picture;
    String username;
    String password;

    public AccountDTO(String email, String fullName, String picture) {
        this.email = email;
        this.fullName = fullName;
        this.picture = picture;
    }
}
