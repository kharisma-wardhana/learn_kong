package com.learn.user.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KongConsumerJWT {
    private String key;
    private String secret;
}
