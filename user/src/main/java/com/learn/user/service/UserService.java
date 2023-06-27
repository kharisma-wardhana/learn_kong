package com.learn.user.service;

import com.learn.user.datasource.mysql.entity.AppUser;
import com.learn.user.datasource.mysql.repo.UserRepo;
import com.learn.user.model.CreateUserReq;
import com.learn.user.model.SignInRequest;
import com.learn.user.model.UpdateUserReq;
import com.learn.user.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepo.findAll().stream().map(
                user -> new UserResponse(
                        user.getId().toString(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getFullName(),
                        user.getAddress(),
                        user.getPhoneNumber(),
                        user.getRoles(),
                        user.getStatus() == 1 ? "Active" : "Inactive",
                        user.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        user.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                )
        ).toList();
    }

    @Override
    public UserResponse getDetailUser(String userId) {
        AppUser user = userRepo.findById(Long.parseLong(userId)).orElseThrow(() -> new RuntimeException("Not Found"));
        return new UserResponse(
                user.getId().toString(),
                user.getUsername(),
                user.getEmail(),
                user.getFullName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getRoles(),
                user.getStatus() == 1 ? "Active" : "Inactive",
                user.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                user.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }

    @Override
    public UserResponse createUser(CreateUserReq request) {
        AppUser user = userRepo.save(
            AppUser.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .fullName(request.getFullname())
                    .address(request.getAddress())
                    .phoneNumber(request.getPhoneNumber())
                    .roles(request.getRoles())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .status(1)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build()
        );
        return new UserResponse(
                user.getId().toString(),
                user.getUsername(),
                user.getEmail(),
                user.getFullName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getRoles(),
                user.getStatus() == 1 ? "Active" : "Inactive",
                user.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                user.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }

    @Override
    public UserResponse updateUser(UpdateUserReq request) {
        return null;
    }

    @Override
    public UserResponse loginUser(SignInRequest request) {
        AppUser user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Not Found"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong username or password");
        }
        return new UserResponse(user.getId().toString(),
                user.getUsername(),
                user.getEmail(),
                user.getFullName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getRoles(),
                user.getStatus() == 1 ? "Active" : "Inactive",
                user.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                user.getUpdatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}
