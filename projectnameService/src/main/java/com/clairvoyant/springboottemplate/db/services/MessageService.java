package com.clairvoyant.springboottemplate.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.clairvoyant.springboottemplate.api.models.Message;
import com.clairvoyant.springboottemplate.db.entities.MessageDO;
import com.clairvoyant.springboottemplate.db.repositories.MessageRepository;


public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    Message message;

    public String saveMessage(final MessageDO message) {
        MessageDO messageDO = messageRepository.save(message);
        return messageDO.getMessageId();
    }
}
