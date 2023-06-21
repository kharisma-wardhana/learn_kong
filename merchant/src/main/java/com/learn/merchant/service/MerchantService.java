package com.learn.merchant.service;

import com.learn.merchant.model.CreateMerchantReq;
import com.learn.merchant.model.MerchantResponse;
import com.learn.merchant.model.UpdateMerchantReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService implements IMerchantService {
    @Override
    public List<MerchantResponse> getAllMerchants() {
        return null;
    }

    @Override
    public List<MerchantResponse> getMerchantByUserId(String userId) {
        return null;
    }

    @Override
    public MerchantResponse getDetailMerchant(String merchantId) {
        return null;
    }

    @Override
    public MerchantResponse createMerchant(CreateMerchantReq request) {
        return null;
    }

    @Override
    public MerchantResponse updateMerchant(UpdateMerchantReq request) {
        return null;
    }
}
