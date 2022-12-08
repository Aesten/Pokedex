package me.aesten.pokedex.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpPokemonResponse implements PokemonFetcher {
    private final CloseableHttpResponse httpResponse;

    private HttpPokemonResponse(CloseableHttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public static HttpPokemonResponse run(HttpPokemonRequest request) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            return new HttpPokemonResponse(httpClient.execute(request.getHttpRequest()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
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
