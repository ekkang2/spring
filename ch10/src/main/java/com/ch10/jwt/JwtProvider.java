package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;


@Getter
@Component
public class JwtProvider {

    private String issuer;
    private SecretKey secretKey;

    public JwtProvider(@Value("${jwt.issuer}") String issuer,
                       @Value("${jwt.secret}") String secretKey) {
        this.issuer = issuer;
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(User user, int days) {
        return null;
    }

    public Claims getClaims(String token) {
        return null;
    }

    public Authentication getAuthentication(String token) {
        return null;
    }

    public void validateToken(String token) {

    }


}
