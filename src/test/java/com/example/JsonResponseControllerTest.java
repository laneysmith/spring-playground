package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(JsonResponseController.class)
public class JsonResponseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getPokemonTrainer_returns200andTrainerDetails() throws Exception {
        MockHttpServletRequestBuilder request = get("/json/trainer")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Laney")))
                .andExpect(jsonPath("$.team", is("blue")))
                .andExpect(jsonPath("$.pokemon.[0].type", is("water")))
                .andExpect(jsonPath("$.pokemon.[1].type", is("fire")));
    }

}