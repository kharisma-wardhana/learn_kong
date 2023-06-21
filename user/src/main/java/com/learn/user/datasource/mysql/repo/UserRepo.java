package com.learn.user.datasource.mysql.repo;

import com.learn.user.datasource.mysql.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
}
