package me.aesten.pokedex.models;

public class Pokemon {
    private String name;
    private String description;
    private Integer weight;
    private Integer height;

    public Pokemon(String name, String description, Integer weight, Integer height) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.height = height;
    }

    public Pokemon(String name, Integer weight, Integer height) {
        this(name, null, weight, height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
