package com.learn.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {
    private String username;

    private String fullname;

    private String email;

    private String password;

    private String address;

    @JsonProperty(value = "phone_number")
    @NotBlank
    private String phoneNumber;
}
