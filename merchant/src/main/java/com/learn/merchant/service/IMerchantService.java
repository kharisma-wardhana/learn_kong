package com.learn.merchant.service;

import com.learn.merchant.model.CreateMerchantReq;
import com.learn.merchant.model.MerchantResponse;
import com.learn.merchant.model.UpdateMerchantReq;

import java.util.List;

public interface IMerchantService {
    List<MerchantResponse> getAllMerchants();
    List<MerchantResponse> getMerchantByUserId(String userId);
    MerchantResponse getDetailMerchant(String merchantId);
    MerchantResponse createMerchant(CreateMerchantReq request);
    MerchantResponse updateMerchant(UpdateMerchantReq request);
}
