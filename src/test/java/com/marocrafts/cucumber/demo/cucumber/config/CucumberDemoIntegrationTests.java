package com.marocrafts.cucumber.demo.cucumber.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.marocrafts.cucumber.demo.CucumberDemoApplication;
import gherkin.deps.com.google.gson.JsonObject;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CucumberDemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application-test.properties")
@Ignore
public class CucumberDemoIntegrationTests {

}
