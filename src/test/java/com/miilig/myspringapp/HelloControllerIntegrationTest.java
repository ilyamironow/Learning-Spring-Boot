package com.miilig.myspringapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * It uses a real server and hits real HTTP endpoints.
 * It uses `TestRestTemplate`, a tool for integration testing REST clients.
 * By using `SpringBootTest.WebEnvironment.RANDOM_PORT`, it creates a real servlet environment at a random port,
 * thus executing a full-stack integration test, making actual network calls.
 * The second test makes sure that the entire integration of components (Controller-Service-Repo) is working fine without mocking any functionality.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getHello() {
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }
}