package com.marocrafts.cucumber.demo.cucumber.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import gherkin.deps.com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Component
public class Services {
    private static final  String SERVER_URL = "http://localhost";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private int serverPort;

    @PostConstruct
    private void wireMockInit() {
        WireMockServer wireMockServer = new WireMockServer(options().port(1234));
        wireMockServer.start();
    }

    private String endpoint() {
        return SERVER_URL + ":" + serverPort;
    }

    public ResponseEntity<Object> getContent(String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(endpoint()+path, HttpMethod.GET,entity,Object.class);
    }

    public ResponseEntity postContent(String path, JsonObject doc){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(doc.toString(), headers);
        return  restTemplate.exchange(endpoint()+path, HttpMethod.POST,entity,Object.class);
    }

    public ResponseEntity deleteContent(String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>( headers);
        return  restTemplate.exchange(endpoint()+path, HttpMethod.DELETE,entity,Object.class);
    }

    public ResponseEntity putContent(String path, JsonObject doc){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(doc.toString(), headers);
        return  restTemplate.exchange(endpoint()+path, HttpMethod.PUT,entity,Object.class);
    }
}
