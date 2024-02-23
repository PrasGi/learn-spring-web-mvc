package core.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGuest() {
        String response = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class).getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals("hello guest", response.trim());
    }

    @Test
    void testPrass() {
        String response = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=prass", String.class).getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals("hello prass", response.trim());
    }
}
