package com.marocrafts.cucumber.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class ApiConsumerController {

    @Autowired
    private ApiConsumer apiConsumer;

    @GetMapping("/api/users")
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<>(apiConsumer.getUsers().getBody(), HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<Object> getUserByID(@PathVariable("id")String userID){
            return new ResponseEntity<>(apiConsumer.getUser(userID).getBody(),HttpStatus.OK);
    }

    @PostMapping("/api/users")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        apiConsumer.addUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")String userID){
        apiConsumer.deleteUser(userID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id")String userID,@RequestBody UserDto userDto){
        apiConsumer.update(userID,userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
