package com.clairvoyant.springboottemplate.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Entity(name = "message")
@Data
public class MessageDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("message_value")
    private String messageValue;

    public MessageDO() {
    }
}
