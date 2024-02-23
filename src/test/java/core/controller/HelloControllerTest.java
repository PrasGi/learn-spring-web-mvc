package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGuestPost() throws Exception {
        mockMvc.perform(post("/hello")).andExpectAll(
                status().isMethodNotAllowed());
    }

    @Test
    void testGuest() throws Exception {
        mockMvc.perform(get("/hello")).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello guest")));
    }
    
    @Test
    void testPras() throws Exception {
        mockMvc.perform(get("/hello?name=prass")).andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("hello prass"))
        );
    }
}
