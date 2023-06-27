package com.learn.auth.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {
    @NotBlank
    private String uid;

    @NotBlank
    private String password;
}
