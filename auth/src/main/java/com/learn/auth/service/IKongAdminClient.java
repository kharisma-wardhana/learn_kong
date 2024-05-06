package com.learn.auth.service;

import com.learn.user.model.KongConsumer;
import com.learn.user.model.KongConsumerJWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "kongAdminClient", url = "${kong.admin.url}")
public interface IKongAdminClient {
    @PostMapping("/consumers")
    ResponseEntity<String> createConsumer(@RequestBody KongConsumer consumer);

    @PatchMapping("/consumers/{username}")
    ResponseEntity<String> updateConsumer(
            @PathVariable("username") String username,
            @RequestBody KongConsumer consumer
    );

    @PostMapping("/consumers/{consumerKey}/jwt")
    ResponseEntity<String> createConsumerJWTCredential(
            @PathVariable("consumerKey") String consumerKey,
            @RequestBody KongConsumerJWT consumerJWT
    );
}
