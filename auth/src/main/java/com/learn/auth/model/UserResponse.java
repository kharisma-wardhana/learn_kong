package com.learn.auth.model;

public record UserResponse(
        String id,
        String username,
        String email,
        String fullname,
        String address,
        String phone_number,
        String roles,
        String status,
        String created_at,
        String updated_at
) {
}