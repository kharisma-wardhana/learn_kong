package com.learn.user.service;

import com.learn.user.exception.AppException;
import com.learn.user.model.KongConsumer;
import com.learn.user.model.KongConsumerJWT;
import com.learn.user.util.RC;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KongService implements IKongService {

    @Value("${app.default.jwtSecret}")
    private String secret;

    private final IKongAdminClient kongAdminClient;

    @Override
    @Async
    public void createConsumer(String username) {
        CompletableFuture.runAsync(() -> {
            KongConsumer consumer = KongConsumer.builder()
                    .username(username)
                    .customId(username)
                    .build();

            ResponseEntity<String> addConsumerResp = kongAdminClient.createConsumer(consumer);

            if (!Objects.equals(HttpStatus.CREATED, addConsumerResp.getStatusCode())) {
                throw new AppException(
                        RC.KONG_SERVICE_FAILED,
                        RC.KONG_ADMIN_ERROR,
                        addConsumerResp.getStatusCode()
                );
            }

            KongConsumerJWT consumerJWT = KongConsumerJWT.builder()
                    .key(username)
                    .secret(secret)
                    .build();
            createConsumerJWTCredential(consumerJWT);
        });
    }

    @Override
    @Async
    public void updateConsumer(String username, String newUsername) {
        CompletableFuture.runAsync(() -> {
            KongConsumer consumer = KongConsumer.builder()
                    .username(newUsername)
                    .customId(newUsername)
                    .build();

            ResponseEntity<String> addConsumerResp = kongAdminClient.updateConsumer(username, consumer);

            if (!Objects.equals(HttpStatus.OK, addConsumerResp.getStatusCode())) {
                throw new AppException(
                        RC.KONG_SERVICE_FAILED,
                        RC.KONG_ADMIN_ERROR,
                        "Error Update Consumer"
                );
            }
        });
    }

    @Override
    public void createConsumerJWTCredential(KongConsumerJWT consumerJWT) {
        ResponseEntity<String> addConsumerJWTResp = kongAdminClient.createConsumerJWTCredential(
                consumerJWT.getKey(),
                consumerJWT
        );

        if (!Objects.equals(HttpStatus.CREATED, addConsumerJWTResp.getStatusCode())) {
            throw new AppException(
                    RC.KONG_SERVICE_FAILED,
                    RC.KONG_ADMIN_ERROR,
                    addConsumerJWTResp.getBody()
            );
        }
    }
}
