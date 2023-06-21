package com.learn.transaction.model;

public record TransactionResponse(
        String id,
        String mpan,
        Double amount,
        String status,
        String created_at,
        String updated_at
) {
}
