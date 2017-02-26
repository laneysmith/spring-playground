package com.example;

import com.example.models.Trainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class AccessingJsonRequests {

    @PostMapping("/trainer")
    public String pokemonTrainerEndpoint(@RequestBody Trainer trainer) {
        return String.format("%s is a trainer on team %s with %s pokemon", trainer.getName(), trainer.getTeam(), trainer.getPokemon().size());
    }
}
