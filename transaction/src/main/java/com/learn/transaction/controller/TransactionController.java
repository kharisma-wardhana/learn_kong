package com.learn.transaction.controller;

import com.learn.transaction.model.BaseResponse;
import com.learn.transaction.service.ITransactionService;
import com.learn.transaction.util.IResponseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController implements IResponseHelper {
    private final ITransactionService transactionService;

    @GetMapping
    public BaseResponse getAllTransactions() {
        return successWithData(transactionService.getAllTransactions());
    }

    @GetMapping(path = "/merchant/{merchantId}")
    public BaseResponse getAllTransactionByMerchantId(@PathVariable String merchantId) {
        return successWithData(transactionService.getAllTransactionByMerchant(merchantId));
    }


}
