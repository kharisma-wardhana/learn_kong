package com.learn.auth.service;

import com.learn.auth.model.AuthResponse;
import com.learn.auth.model.SignInRequest;
import com.learn.auth.model.SignUpRequest;

public interface IAuthService {

    AuthResponse signIn(SignInRequest request);

    AuthResponse signUp(SignUpRequest request);
}
