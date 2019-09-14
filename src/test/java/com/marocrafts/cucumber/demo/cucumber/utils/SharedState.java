package com.marocrafts.cucumber.demo.cucumber.utils;

import org.springframework.http.ResponseEntity;

public class SharedState {

    public static Object body;
    public static int status;

    public static void setResponseData(ResponseEntity<Object> responseEntity){
        body=responseEntity.getBody();
        status=responseEntity.getStatusCodeValue();

    }
}
