package com.learn.user.controller;

import com.learn.user.model.BaseResponse;
import com.learn.user.model.CreateUserReq;
import com.learn.user.model.SignInRequest;
import com.learn.user.model.UpdateUserReq;
import com.learn.user.service.IUserService;
import com.learn.user.util.IResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements IResponseHelper {
    private final IUserService userService;

    @GetMapping
    public BaseResponse getAllUsers(
            @RequestParam(defaultValue = "1") String page,
            @RequestParam String perPage,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "asc") String orderBy,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return successWithData(userService.getAllUsers());
    }

    @GetMapping(
            path = "/{userId}"
    )
    public BaseResponse getUserDetail(@PathVariable String userId) {
        return successWithData(userService.getDetailUser(userId));
    }

    @PostMapping
    public BaseResponse createNewUser(@RequestBody @Valid CreateUserReq request) {
        return successWithData(userService.createUser(request));
    }

    @PatchMapping
    public BaseResponse updateUserData(@RequestBody @Valid UpdateUserReq request) {
        return successWithData(userService.updateUser(request));
    }

    @PostMapping(
            path = "/login"
    )
    public BaseResponse loginUser(@RequestBody @Valid SignInRequest request) {
        return successWithData(userService.loginUser(request));
    }
}
