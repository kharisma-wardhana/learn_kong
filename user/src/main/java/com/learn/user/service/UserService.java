package com.learn.user.service;

import com.learn.user.model.CreateUserReq;
import com.learn.user.model.UpdateUserReq;
import com.learn.user.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }

    @Override
    public UserResponse getDetailUser(String userId) {
        return null;
    }

    @Override
    public UserResponse createUser(CreateUserReq request) {
        return null;
    }

    @Override
    public UserResponse updateUser(UpdateUserReq request) {
        return null;
    }
}
