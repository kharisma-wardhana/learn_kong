package com.learn.user.controller;

import com.learn.user.model.BaseResponse;
import com.learn.user.model.CreateUserReq;
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
            @RequestParam String name,
            @RequestParam String orderBy,
            @RequestParam String sortBy
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
}
