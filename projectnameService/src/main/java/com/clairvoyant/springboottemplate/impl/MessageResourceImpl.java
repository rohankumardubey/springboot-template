package com.clairvoyant.springboottemplate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.clairvoyant.springboottemplate.api.MessageResource;
import com.clairvoyant.springboottemplate.api.models.Message;
import com.clairvoyant.springboottemplate.db.services.MessageService;
import com.clairvoyant.springboottemplate.mappers.MessageMapper;


@Component
@Scope("request")
public class MessageResourceImpl implements MessageResource {

    @Autowired
    MessageService messageService;

    @Override
    public String getMessage() {
        return "Hello World!!!!!";
    }

    @Override
    public String saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(MessageMapper.mapMessage(message));
    }
}
