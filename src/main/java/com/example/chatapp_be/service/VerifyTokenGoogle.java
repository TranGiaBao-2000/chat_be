package com.example.chatapp_be.service;

import com.example.chatapp_be.dto.Account;
import com.example.chatapp_be.exception.InvalidToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

//anotation
@Service
public class VerifyTokenGoogle {

    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
            .setAudience(Collections.singletonList("233707672502-t92c9697ga75uqddtk0jkhnj72lp8873.apps.googleusercontent.com"))
            .build();

    public Account verifyToken(String token){
        try{
            GoogleIdToken idToken = verifier.verify(token);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                String email = payload.getEmail();
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");
                Account account = new Account(email, name, pictureUrl);
                return account;
            } else {
                throw new InvalidToken("Token invalid!!!");
            }
        }catch (GeneralSecurityException e){
            return null;
        }catch (IOException ioException){
            return null;
        }catch (IllegalArgumentException illegalArgumentException){
            // sai định dạng
            throw new InvalidToken("Malformed token!!!");
        }
    }
}


// 1. Token chuẩn => trả về account
// 2. Token đúng định dạng mà sai
// 3. Token sai định dạng