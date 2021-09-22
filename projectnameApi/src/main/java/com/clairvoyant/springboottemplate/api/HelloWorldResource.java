package com.clairvoyant.springboottemplate.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clairvoyant.springboottemplate.api.models.Message;


@RestController
public interface HelloWorldResource {

    @GetMapping("/hello")
    String getMessage();

    @PostMapping
    String saveMessage(Message message);
}
