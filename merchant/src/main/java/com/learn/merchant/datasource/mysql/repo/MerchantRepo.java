package com.learn.merchant.datasource.mysql.repo;

import com.learn.merchant.datasource.mysql.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepo extends JpaRepository<Merchant, Long> {
}
