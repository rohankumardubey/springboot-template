package com.clairvoyant.springboottemplate.services;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;
import com.clairvoyant.springboottemplate.api.models.Message;
import com.clairvoyant.springboottemplate.db.entities.MessageDO;
import com.clairvoyant.springboottemplate.db.services.MessageService;
import com.clairvoyant.springboottemplate.impl.HelloWorldResourceImpl;


public class MessageServiceTest {

    private static final DockerImageName DEFAULT_IMAGE_NAME = DockerImageName.parse("postgres");
    public static final String HELLO_WORLD = "Hello World!!!!!";

    @Autowired
    MessageService messageService;

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer(DEFAULT_IMAGE_NAME.withTag("9.6.12"))
            .withUsername("duke")
            .withPassword("password")
            .withDatabaseName("test");

    // requires Spring Boot >= 2.2.6
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Test
    public void saveMessage() throws Exception {
        MessageDO messageDO = new MessageDO();
        messageDO.setMessageValue("New message");
        String mesageId = messageService.saveMessage(messageDO);
        System.out.println(mesageId);
    }
}
