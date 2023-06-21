package com.learn.transaction.service;

import com.learn.transaction.model.CreateTransactionReq;
import com.learn.transaction.model.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Override
    public List<TransactionResponse> getAllTransactions() {
        return null;
    }

    @Override
    public List<TransactionResponse> getAllTransactionByMerchant(String merchantId) {
        return null;
    }

    @Override
    public TransactionResponse createTransaction(CreateTransactionReq request) {
        return null;
    }
}
