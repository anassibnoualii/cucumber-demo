package com.marocrafts.cucumber.demo.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiConsumer {


    @Value("${users.url.path}")
    private String usersUrlPath;

    private RestTemplate restTemplate;


    public ApiConsumer() {
        this.restTemplate = new RestTemplate();
    }


    public ResponseEntity<Object> getUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(usersUrlPath, HttpMethod.GET,entity,Object.class);
    }
    public ResponseEntity<Object> getUser(String userID){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(usersUrlPath.concat("/").concat(userID), HttpMethod.GET,entity,Object.class);
    }


    public ResponseEntity addUser(UserDto userDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(userDto, headers);
        return  restTemplate.exchange(usersUrlPath, HttpMethod.POST,entity,Object.class);
    }

    public ResponseEntity deleteUser(String userID){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>( headers);
        return  restTemplate.exchange(usersUrlPath.concat("/").concat(userID), HttpMethod.DELETE,entity,Object.class);
    }

    public ResponseEntity update(String userID, UserDto userDto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>(userDto, headers);
        return  restTemplate.exchange(usersUrlPath.concat("/").concat(userID), HttpMethod.PUT,entity,Object.class);
    }
}
