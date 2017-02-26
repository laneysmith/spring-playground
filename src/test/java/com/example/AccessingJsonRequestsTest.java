package com.example;

import com.example.models.Pokemon;
import com.example.models.Trainer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccessingJsonRequests.class)
public class AccessingJsonRequestsTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void trainerTest_stringLiteral() throws Exception {
        MockHttpServletRequestBuilder request = post("/json/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Laney\", \"team\": \"blue\", \"pokemon\": [{\"type\": \"water\", \"level\": \"45\"}, {\"type\": \"fire\", \"level\": \"15\"}]}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Laney is a trainer on team blue with 2 pokemon"));
    }

    @Test
    public void trainerTest_gson() throws Exception {
        List<Pokemon> pokemonList = new ArrayList<>();

        Pokemon pokemon1 = new Pokemon("water", "45");
        Pokemon pokemon2 = new Pokemon("fire", "15");

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);

        Trainer trainer = new Trainer();
        trainer.setName("Laney");
        trainer.setTeam("blue");
        trainer.setPokemon(pokemonList);

        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(trainer);

        MockHttpServletRequestBuilder request = post("/json/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Laney is a trainer on team blue with 2 pokemon"));
    }

    @Test
    public void trainerTest_fixture() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/json/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Laney is a trainer on team blue with 2 pokemon"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.toURI())));
    }
}