package com.clairvoyant.springboottemplate.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Message {

    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("message_value")
    private String messageValue;

}
