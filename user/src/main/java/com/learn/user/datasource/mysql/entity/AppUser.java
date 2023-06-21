package com.learn.user.datasource.mysql.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    private String roles;

    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
