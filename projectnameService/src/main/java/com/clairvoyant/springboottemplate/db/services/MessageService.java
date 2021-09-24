package com.clairvoyant.springboottemplate.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.clairvoyant.springboottemplate.db.entities.MessageDO;
import com.clairvoyant.springboottemplate.db.repositories.MessageRepository;


@Component
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public String saveMessage(final MessageDO message) {
        MessageDO messageDO = messageRepository.save(message);
        return messageDO.getMessageId();
    }
}
