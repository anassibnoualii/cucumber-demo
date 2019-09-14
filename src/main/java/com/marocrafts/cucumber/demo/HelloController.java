package com.marocrafts.cucumber.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<Hello> sayHello(){
        return new ResponseEntity<>(new Hello("Hello Crafts"), HttpStatus.OK);
    }
}
