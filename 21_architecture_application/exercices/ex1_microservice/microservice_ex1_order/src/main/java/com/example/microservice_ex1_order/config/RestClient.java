package com.example.microservice_ex1_order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient<T,V> {
    @Value("${api.url}")
    private String apiUrl;
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public RestClient() {
        this.restTemplate = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("Content-Type", "application/json");
    }

    public T Get(String uri, Class<T> type) {
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        return restTemplate.getForObject(apiUrl + uri, type, headers);
    }

    public T post(String uri, V data, Class<T> type) {
        HttpEntity<V> entity = new HttpEntity<>(data, headers);
        return restTemplate.postForObject(apiUrl + uri, entity, type, headers);
    }
}
