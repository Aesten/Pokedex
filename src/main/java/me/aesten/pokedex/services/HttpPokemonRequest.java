package me.aesten.pokedex.services;

import org.apache.http.client.methods.HttpGet;


public class HttpPokemonRequest{
    private final HttpGet httpRequest;

    private HttpPokemonRequest(HttpGet httpRequest) {
        this.httpRequest = httpRequest;
    }

    /**
     * Calls a HttpPokemonRequestBuilder. You cannot directly use the constructor for the HttpPokemonRequest.
     *
     * @return an HttpPokemonRequestBuilder
     */
    public static Builder builder() {
        return new Builder(1);
    }

    public HttpGet getHttpRequest() {
        return httpRequest;
    }

    /**
     * The HttpPokemonRequestBuilder allows to prepare a HttpGet request.
     */
    public static class Builder {
        private Integer requestPokemonId;

        public Builder(int id) {
            requestPokemonId = id;
        }

        public Builder setRequestPokemonId(int id) {
            requestPokemonId = id;
            return this;
        }

        public HttpPokemonRequest build() {
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + requestPokemonId);
            request.addHeader("content-type", "application/json");
            return new HttpPokemonRequest(request);
        }
    }
}
