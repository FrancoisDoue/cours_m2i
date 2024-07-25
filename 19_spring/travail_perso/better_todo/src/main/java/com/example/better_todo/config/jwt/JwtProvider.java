package com.example.better_todo.config.jwt;

import com.example.better_todo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    @Value("${api.secret}")
    private String apiSecret;

    private SecretKey getSecretKey() {
        byte[] keyBytes = Base64.getDecoder().decode(apiSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractToken(HttpHeaders headers) {
        return Optional.of((Objects.requireNonNull(headers.get("Authorization")).stream().findAny().orElseThrow(
                    () -> new AuthenticationCredentialsNotFoundException("Authorization header not found")
                ))
                .split(" ")[1])
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("Invalid JWT token"));
    }

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 1000 * 60 * 60);
        String roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(username)
                .claim("id", ((User) authentication.getPrincipal()).getId())
                .claim("roles", roles)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        }
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

}
