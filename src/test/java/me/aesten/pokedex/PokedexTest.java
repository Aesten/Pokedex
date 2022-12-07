package me.aesten.pokedex;

import org.junit.Test;

import static org.junit.Assert.*;

public class PokedexTest {

    @Test
    public void getName() {
        Pokedex pokedex = new Pokedex();
        assertEquals("Hello", pokedex.getName());
    }
}