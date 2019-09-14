package com.marocrafts.cucumber.demo.cucumber.config;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
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
		return restTemplate.getForEntity(endpoint()+path,Object.class);
	}
}
