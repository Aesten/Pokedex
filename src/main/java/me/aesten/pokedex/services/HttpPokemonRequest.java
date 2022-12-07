package me.aesten.pokedex.services;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpPokemonRequest{
    private Integer requestPokemonId;
    private HttpGet request;
    public static HttpPokemonRequest create() {
        return new HttpPokemonRequest(1);
    }

    public HttpPokemonRequest(int requestPokemonId) {
        this.requestPokemonId = requestPokemonId;
    }

    public HttpPokemonRequest setRequestPokemonId(int id) {
        requestPokemonId = id;
        return this;
    }

    public HttpPokemonRequest build() {
        request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + requestPokemonId);
        request.addHeader("content-type", "application/json");
        return this;
    }

    public HttpPokemonResponse run() {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            return new HttpPokemonResponse(httpClient.execute(request));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
