package com.example.better_todo.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class JwtProvider {

    @Value("${api.secret}")
    private String apiSecret;

//    private SecretKey getSecretKey() {
//        byte[] keyBytes = Base64.getDecoder().decode(apiSecret);
//    }

}
