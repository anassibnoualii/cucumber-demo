package com.marocrafts.cucumber.demo.cucumber.steps;

import com.marocrafts.cucumber.demo.cucumber.config.CucumberDemoIntegrationTests;
import com.marocrafts.cucumber.demo.cucumber.utils.SharedState;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberStepDefinitions extends CucumberDemoIntegrationTests {

	@When("i call GET on {word}")
	public void whenICallGetWithPath(String path){
		SharedState.setResponseData(getContent(path));
	}

	@Then("the response body is :$")
	public void theResponseBodyIs(String doc) throws JSONException {
		JSONAssert.assertEquals(doc,new Gson().toJson(SharedState.body),false);
	}
	@And("http status is {int}")
	public void httpStatusIs(int status){
		assertThat(SharedState.status).isEqualTo(status);
	}

}
