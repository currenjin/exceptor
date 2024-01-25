package com.currenjin.exceptor.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ExampleBeforeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void _400_bad_request() throws Exception {
        mvc.perform(get("/example/before"))
                .andExpect(status().isBadRequest());
    }
}
