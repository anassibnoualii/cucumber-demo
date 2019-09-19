package com.marocrafts.cucumber.demo.cucumber.utils;

import gherkin.deps.com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;

public class SharedState {
    public static ResponseEntity responseEntity;
    public static JsonObject body;
    public static String uri;

    public static void init(){
        responseEntity = null;
        body = null;
    }
}
