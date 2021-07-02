package com.clairvoyant.springboottemplate.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface HelloWorldResource {

    @GetMapping("/hello")
    String getHello();
}
