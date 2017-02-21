package com.example;

import com.example.models.Pokemon;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccessingFormData {

    @PostMapping("/cat")
    public String getCatNameAsRawString(@RequestParam String name) {
        return name;
    }

    @PostMapping("/dog")
    public String getDogInfoAsMap(@RequestParam Map<String, String> dogInfo) {
        return dogInfo.toString();
    }

    @PostMapping("/pokemon")
    public String getPokemonInfo(@RequestBody Pokemon pokemon) {
        return pokemon.toString();
    }
}
