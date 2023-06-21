package com.learn.merchant.model;

public record MerchantResponse(
        String id,
        String name,
        String type,
        String qr_type,
        String nmid,
        String mid,
        String mpan,
        String address,
        String status,
        String created_at,
        String updated_at
) {
}
