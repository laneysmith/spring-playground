package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello!!";
    }

    @PostMapping("/stuff")
    public String postStuff() {
        return "you posted some stuff!!";
    }
}
