package com.learn.auth.controller;

import com.learn.auth.model.BaseResponse;
import com.learn.auth.model.SignInRequest;
import com.learn.auth.model.SignUpRequest;
import com.learn.auth.service.IAuthService;
import com.learn.auth.util.IResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController implements IResponseHelper {
    private final IAuthService authService;

    @PostMapping(
            path = "/sign-up"
    )
    public BaseResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return successWithData(authService.signUp(request));
    }

    @PostMapping(
            path = "/sign-in"
    )
    public BaseResponse signIn(@RequestBody @Valid SignInRequest request) {
        return successWithData(authService.signIn(request));
    }
}
