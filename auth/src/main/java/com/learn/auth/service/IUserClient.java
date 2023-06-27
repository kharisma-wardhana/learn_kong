package com.learn.auth.service;

import com.learn.auth.model.BaseResponse;
import com.learn.auth.model.SignInRequest;
import com.learn.auth.model.SignUpRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "user",
        url = "${client.user.url}"
)
public interface IUserClient {
    @PostMapping("/api/users")
    BaseResponse createNewUser(SignUpRequest request);

    @PostMapping("/api/users/login")
    BaseResponse loginUser(SignInRequest request);
}
