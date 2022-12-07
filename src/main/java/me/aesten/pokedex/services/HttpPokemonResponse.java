package me.aesten.pokedex.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpPokemonResponse implements PokemonDataMap{
    private final CloseableHttpResponse httpResponse;

    public HttpPokemonResponse(CloseableHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Override
    public Map<String, Object> getAsMap() {
        String jsonResponse = "";
        try {
            jsonResponse = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            return new ObjectMapper().readValue(jsonResponse, HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
