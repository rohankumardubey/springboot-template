package com.clairvoyant.springboottemplate.mappers;

import com.clairvoyant.springboottemplate.api.models.Message;
import com.clairvoyant.springboottemplate.db.entities.MessageDO;


public class MessageMapper {

    public static MessageDO mapMessage(Message message) {
        MessageDO messageDO = new MessageDO();
        messageDO.setMessageId(message.getMessageId());
        message.setMessageValue(message.getMessageValue());
        return messageDO;
    }
}
