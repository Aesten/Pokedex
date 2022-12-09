package me.aesten.pokedex.models;

/**
 * A simple Pokemon model class
 */
public class PokemonBasic {
    private int id;
    private String name;
    private Integer weight;
    private Integer height;

    public PokemonBasic(int id, String name, Integer weight, Integer height) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
