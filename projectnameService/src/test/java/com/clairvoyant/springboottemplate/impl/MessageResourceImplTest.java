package com.clairvoyant.springboottemplate.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.junit.jupiter.api.Test;
import org.testcontainers.utility.DockerImageName;
import com.clairvoyant.springboottemplate.api.models.Message;
import com.clairvoyant.springboottemplate.db.services.MessageService;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@Testcontainers
public class MessageResourceImplTest {

    private static final DockerImageName DEFAULT_IMAGE_NAME = DockerImageName.parse("postgres");
    public static final String HELLO_WORLD = "Hello World!!!!!";


    @InjectMocks
    MessageResourceImpl helloWorldResource;

    @Mock
    MessageService messageService;


    @Test
    public void getHello() throws Exception {
        String hello = helloWorldResource.getMessage();
        System.out.println(hello);
        assertEquals(HELLO_WORLD, hello);
    }

    @Test
    public void saveMessage() throws Exception {
        Message message = new Message();
        message.setMessageValue("New message");
        when(messageService.saveMessage(any())).thenReturn("1");
        String mesageId = helloWorldResource.saveMessage(message);
        assertEquals("1", mesageId);
    }
}
