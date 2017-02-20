package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccessingPathVariables.class)
public class AccessingPathVariablesTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void catEndpointTest() throws Exception {
        String breed = "sphynx";
        int age = 4;

        this.mvc.perform(get(String.format("/cat/breed/%s/age/%d", breed, age)))
                .andExpect(status().isOk())
                .andExpect(content().string("Cat breed is sphynx and age is 4"));
    }

    @Test
    public void dogEndpointTest() throws Exception {
        String breed = "pug";
        int age = 7;

        this.mvc.perform(get(String.format("/dog/breed/%s/age/%d", breed, age)))
                .andExpect(status().isOk())
                .andExpect(content().string("{breed=pug, age=7}"));
    }

    @Test
    public void pokemonEndpointTest() throws Exception {
        String type = "water";
        int level = 16;

        this.mvc.perform(get(String.format("/pokemon/type/%s/level/%d", type, level)))
                .andExpect(status().isOk())
                .andExpect(content().string("Pokemon type is water and level is 16"));
    }
}