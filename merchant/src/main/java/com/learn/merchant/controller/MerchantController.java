package com.learn.merchant.controller;

import com.learn.merchant.model.BaseResponse;
import com.learn.merchant.model.CreateMerchantReq;
import com.learn.merchant.model.UpdateMerchantReq;
import com.learn.merchant.service.IMerchantService;
import com.learn.merchant.util.IResponseHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merchants")
@RequiredArgsConstructor
public class MerchantController implements IResponseHelper {
    private final IMerchantService merchantService;

    @GetMapping
    public BaseResponse getAllMerchants() {
        return successWithData(merchantService.getAllMerchants());
    }

    @GetMapping(
            path = "/user/{userId}"
    )
    public BaseResponse getAllMerchantByUser(@PathVariable String userId) {
        return successWithData(merchantService.getMerchantByUserId(userId));
    }

    @GetMapping(
            path = "{merchantId}"
    )
    public BaseResponse getDetailMerchant(@PathVariable String merchantId) {
        return successWithData(merchantService.getDetailMerchant(merchantId));
    }

    @PostMapping
    public BaseResponse createNewMerchant(@RequestBody @Valid CreateMerchantReq request) {
        return successWithData(merchantService.createMerchant(request));
    }

    @PatchMapping
    public BaseResponse updateMerchant(@RequestBody @Valid UpdateMerchantReq request) {
        return successWithData(merchantService.updateMerchant(request));
    }
}
