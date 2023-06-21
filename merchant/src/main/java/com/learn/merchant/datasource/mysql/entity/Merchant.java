package com.learn.merchant.datasource.mysql.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "merchants")
@Entity
@Getter
@Setter
@Builder
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nmid;

    private String mid;

    private String mpan;

    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "merchant_type")
    private Integer merchantType;

    @Column(name = "qr_type")
    private Integer qrType;

    private String address;

    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
