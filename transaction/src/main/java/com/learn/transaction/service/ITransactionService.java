package com.learn.transaction.service;

import com.learn.transaction.model.CreateTransactionReq;
import com.learn.transaction.model.TransactionResponse;

import java.util.List;

public interface ITransactionService {
    List<TransactionResponse> getAllTransactions();
    List<TransactionResponse> getAllTransactionByMerchant(String merchantId);
    TransactionResponse createTransaction(CreateTransactionReq request);
}
