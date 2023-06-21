package com.learn.transaction.controller;

import com.learn.transaction.service.ITransactionService;
import com.learn.transaction.util.IResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController implements IResponseHelper {
    private final ITransactionService transactionService;

}
