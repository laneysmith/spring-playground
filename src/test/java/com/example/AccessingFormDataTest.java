package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccessingFormData.class)
public class AccessingFormDataTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void catEndpointTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/cat")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Squidward");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Squidward"));
    }

    @Test
    public void dogEndpointTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/dog")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Possum")
                .param("color", "brown");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{name=Possum, color=brown}"));
    }

    @Test
    public void pokemonEndpointTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/dog")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "water")
                .param("level", "23");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{type=water, level=23}"));
    }
}