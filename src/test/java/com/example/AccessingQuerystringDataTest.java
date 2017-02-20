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
@WebMvcTest(AccessingQuerystringData.class)
public class AccessingQuerystringDataTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCat_returnsStatus200() throws Exception {
        this.mvc.perform(get("/cat?breed=siamese"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cat breed: siamese"));
    }

    @Test
    public void getDogs_returnsStatus200() throws Exception {
        this.mvc.perform(get("/dogs?breed=husky&type=goodBoy"))
                .andExpect(status().isOk())
                .andExpect(content().string("{breed=husky, type=goodBoy}"));
    }

    @Test
    public void getPokemon_returnsStatus200() throws Exception {
        this.mvc.perform(get("/pokemon?type=water&level=16"))
                .andExpect(status().isOk())
                .andExpect(content().string("Pokemon type is water and level is 16"));
    }
}