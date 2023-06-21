package com.learn.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserReq {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String fullname;

    @NotBlank
    private String address;

    @JsonProperty(value = "phone_number")
    @NotBlank
    private String phoneNumber;

    private String roles;
}
