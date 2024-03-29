package com.marocrafts.cucumber.demo.cucumber.config;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",glue = "com/marocrafts/cucumber/demo/cucumber/steps", plugin = {"pretty", "html:target/cucumber"})
public class CucumberConfig {

}
