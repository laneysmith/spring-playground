package com.example;

import com.example.models.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccessingPathVariables {

    @GetMapping("/cat/breed/{breed}/age/{age}")
    public String getCat(@PathVariable String breed, @PathVariable String age) {
        return String.format("Cat breed is %s and age is %s", breed, age);
    }

    @GetMapping("/dog/breed/{breed}/age/{age}")
    public String getDog(@PathVariable Map pathVariables) {
        return pathVariables.toString();
    }

    @GetMapping("/pokemon/type/{type}/level/{level}")
    public String getPokemon(Pokemon pokemon) {
        return String.format("Pokemon type is %s and level is %s", pokemon.getType(), pokemon.getLevel());
    }
}
