package com.learn.user.service;

import com.learn.user.model.CreateUserReq;
import com.learn.user.model.SignInRequest;
import com.learn.user.model.UpdateUserReq;
import com.learn.user.model.UserResponse;

import java.util.List;

public interface IUserService {
    List<UserResponse> getAllUsers();
    UserResponse getDetailUser(String userId);
    UserResponse createUser(CreateUserReq request);
    UserResponse updateUser(UpdateUserReq request);
    UserResponse loginUser(SignInRequest request);
}
