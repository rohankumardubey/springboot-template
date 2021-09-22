package com.clairvoyant.springboottemplate.tests;


import java.net.URL;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HelloWorldService {

        @LocalServerPort
        private int port;

        private URL base;
    private static DockerImageName dockerImageName = DockerImageName.parse("postgres:13-alpine");

    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer(dockerImageName);

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    }

    @Test
    public void contextLoads() {
//        boolean running = postgreSQLContainer.isRunning();
//        postgreSQLContainer.start();
//        System.out.println(running);
//        System.out.println(postgreSQLContainer.getDatabaseName());
//        System.out.println(postgreSQLContainer.getJdbcUrl());
    }

    @Autowired
    private TestRestTemplate template;

        @BeforeEach
        public void setUp() throws Exception {
            this.base = new URL("http://localhost:" + port + "/hello");
        }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/hello",
                String.class);
        System.out.println(response.getBody());
    }
}
