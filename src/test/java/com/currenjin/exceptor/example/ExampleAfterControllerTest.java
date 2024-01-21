package com.currenjin.exceptor.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ExampleAfterController.class)
class ExampleAfterControllerTest {

    @Autowired
    MockMvc mvc;

    // TODO: 테스트 개선 필요
    @Test
    void _400_bad_request() throws Exception {
        mvc.perform(get("/example/after"))
                .andExpect(status().isBadRequest());
    }
}
