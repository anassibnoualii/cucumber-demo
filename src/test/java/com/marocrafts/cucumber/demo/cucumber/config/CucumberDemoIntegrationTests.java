package com.marocrafts.cucumber.demo.cucumber.config;

import gherkin.deps.com.google.gson.JsonObject;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class CucumberDemoIntegrationTests {

	private static final  String SERVER_URL = "http://localhost";

	private RestTemplate restTemplate;

	@LocalServerPort
	private  int port;

	public CucumberDemoIntegrationTests() {
		this.restTemplate = new RestTemplate();
	}

	private String endpoint() {
		return SERVER_URL + ":" + port;
	}

	public ResponseEntity<Object> getContent(String path){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(headers);
		return restTemplate.exchange(endpoint()+path,HttpMethod.GET,entity,Object.class);
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
