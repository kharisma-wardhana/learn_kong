package com.learn.user.model;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
