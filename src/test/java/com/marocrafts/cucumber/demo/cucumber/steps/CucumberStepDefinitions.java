package com.marocrafts.cucumber.demo.cucumber.steps;

import com.marocrafts.cucumber.demo.cucumber.config.CucumberDemoIntegrationTests;
import com.marocrafts.cucumber.demo.cucumber.utils.SharedState;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonElement;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberStepDefinitions extends CucumberDemoIntegrationTests {

	@Before
	public void init (){
		SharedState.init();
	}

	@When("i call GET on {word}")
	public void whenICallGetWithPath(String path){
		SharedState.responseEntity = getContent(path);
	}

	@When("i call POST on {word} with the request body")
	public void iCallPostOnUsersWithTheFollowingRequestBody(String path) {
		SharedState.responseEntity = postContent(path,SharedState.body);
	}
	@Then("the response body is :$")
	public void theResponseBodyIs(String doc) throws JSONException {
		JSONAssert.assertEquals(doc, new Gson().toJson(SharedState.responseEntity.getBody()), false);	}

	@And("http status is {int}")
	public void httpStatusIs(int status){
		assertThat(SharedState.responseEntity.getStatusCodeValue()).isEqualTo(status);
	}

	@Given("i set the following request body :")
	public void iSetTheFollowingRequestBody(String doc) {
		SharedState.body = new Gson().fromJson(doc, JsonElement.class).getAsJsonObject();
	}

	@When("i call DELETE on {word} with the request body")
	public void iCallDELETEOnUsersWithTheRequestBody(String path) {
		SharedState.responseEntity = deleteContent(path);

	}

	@And("i call PUT on {word} with the request body")
	public void iCallPUTOnUsersWithTheRequestBody(String path) {
		SharedState.responseEntity = putContent(path,SharedState.body);
	}
}
