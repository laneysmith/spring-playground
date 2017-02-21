package com.example;

import com.example.models.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccessingQuerystringData {

    @GetMapping("/cat")
    public String getCat(@RequestParam String breed) {
        return String.format("Cat breed: %s", breed);
    }

    @GetMapping("/dogs")
    public String getDogs(@RequestParam Map querystring) {
        return querystring.toString();
    }

    @GetMapping("/pokemon")
    public String getPokemon(Pokemon pokemon) {
        return String.format("Pokemon type is %s and level is %s", pokemon.getType(), pokemon.getLevel());
    }
}
