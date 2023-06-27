package com.learn.auth.model;

import java.util.Map;

public record AuthResponse(
        UserResponse user,
        String token
) {
}
