package com.example.chatapp_be.controller;

import com.example.chatapp_be.dto.Token;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

//anotation
@RestController
public class VerifyTokenGoogle {

    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
            // Specify the CLIENT_ID of the app that accesses the backend:
            .setAudience(Collections.singletonList("233707672502-t92c9697ga75uqddtk0jkhnj72lp8873.apps.googleusercontent.com"))
            // Or, if multiple clients access the backend:
            //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .build();

    /*
    * method:
    *   - Get: lấy data
    *   - Post: create data
    *   - Put: update
    *   - Delete: delete
    * */

    @PostMapping("/verify")
    public void verifyToken(@RequestBody Token token){
        try{
            GoogleIdToken idToken = verifier.verify(token.getTokenid());
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();

                // Print user identifier
                String userId = payload.getSubject();
                System.out.println("User ID: " + userId);

                // Get profile information from payload
                String email = payload.getEmail();
                boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");
                String locale = (String) payload.get("locale");
                String familyName = (String) payload.get("family_name");
                String givenName = (String) payload.get("given_name");

                System.out.println("email: "+email);
                System.out.println("name: "+name);
                System.out.println("emailVerified: "+emailVerified);
                System.out.println("pictureUrl: "+pictureUrl);
                System.out.println("locale: "+locale);
                System.out.println("familyName: "+familyName);
                System.out.println("givenName: "+givenName);

            } else {
                System.out.println("Invalid ID token.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/get")
    public void get(){
        System.out.println("test get");
    }
}


