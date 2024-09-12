package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .uid("a101")
                .name("김유신")
                .birth("1990-09-09")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user, 1);
        System.out.println(jwt); // 출력된 토큰 jwt 사이트에 입력

    }

    @Test
    void getClaims() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJya2RkbXNydWQyN0BnbWFpbC5jb20iLCJpYXQiOjE3MjYxMjI5MDYsImV4cCI6MTcyNjIwOTMwNiwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.MBPxOyNFqcQrEqxHVydoO5xIKi6rtjuS0QwLx7ZeQL0";

        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + "," + role);

    }

    // 안해도 됨
    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJya2RkbXNydWQyN0BnbWFpbC5jb20iLCJpYXQiOjE3MjYxMjI5MDYsImV4cCI6MTcyNjIwOTMwNiwidXNlcm5hbWUiOiJhMTAxIiwicm9sZSI6IkFETUlOIn0.MBPxOyNFqcQrEqxHVydoO5xIKi6rtjuS0QwLx7ZeQL0";

        try {
            jwtProvider.validateToken(token);

            System.out.println("토큰 이상 없음");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}