package com.learn.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KongConsumer {
    private String username;

    @JsonProperty(value = "custom_id")
    private String customId;
}
