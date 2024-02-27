package core.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FormControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFormHello() throws Exception {
            mockMvc.perform(get("/form")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", "prass")
        )
        .andExpectAll(
            status().isOk(),
            content().string(Matchers.containsString("Hello prass"))
                    );
    }
}
