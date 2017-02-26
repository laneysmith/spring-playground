package com.example;

import com.example.models.Pokemon;
import com.example.models.Trainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonResponseController {

    @GetMapping("/trainer")
    public Trainer getPokemonTrainer() {
        List<Pokemon> pokemonList = new ArrayList<>();

        Pokemon pokemon1 = new Pokemon("water", "45");
        Pokemon pokemon2 = new Pokemon("fire", "15");

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);

        Trainer trainer = new Trainer();
        trainer.setName("Laney");
        trainer.setTeam("blue");
        trainer.setPokemon(pokemonList);

        return trainer;
    }

}
