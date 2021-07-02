package com.clairvoyant.springboottemplate.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.clairvoyant.springboottemplate.api.HelloWorldResource;

@Component
@Scope("request")
public class HelloWorldResourceImpl implements HelloWorldResource {

    @Override
    public String getHello() {
        return "Hello World!!!!!";
    }
}
