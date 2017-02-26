package com.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    private String type;
    private String level;

    @JsonCreator
    public Pokemon(@JsonProperty("type") String type, @JsonProperty("level") String level) {
        this.type = type;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
