package com.learn.auth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.auth.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements IAuthService {

    private final IUserClient userClient;

    private final ObjectMapper mapper;

    @Override
    public AuthResponse signIn(SignInRequest request) {
        BaseResponse response = userClient.loginUser(request);
        UserResponse user = mapper.convertValue(response.getData(), UserResponse.class);
        return new AuthResponse(user, generateToken(user));
    }

    @Override
    public AuthResponse signUp(SignUpRequest request) {
        BaseResponse response = userClient.createNewUser(request);
        UserResponse user = mapper.convertValue(response.getData(), UserResponse.class);
        return new AuthResponse(user, generateToken(user));
    }

    private String generateToken(UserResponse user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", user.username())
                    .withExpiresAt(Instant.from(LocalDateTime.now().plusMinutes(Long.parseLong("15"))))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            log.error("Failed Generate JWT Token {}", exception.getMessage());
        }
        return null;
    }
}
