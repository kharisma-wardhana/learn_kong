package com.learn.auth.service;

import com.learn.user.model.KongConsumerJWT;

public interface IKongService {
    void createConsumer(String username);
    void updateConsumer(String username, String newUsername);
    void createConsumerJWTCredential(KongConsumerJWT consumerJWT);
}
