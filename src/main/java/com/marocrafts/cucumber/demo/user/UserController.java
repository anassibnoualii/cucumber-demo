package com.marocrafts.cucumber.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        return new ResponseEntity<>(UserMapper.mapToUsersDto(userRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserByID(@PathVariable("id")String userID){
        UserEntity userEntity = userRepository.findById(userID).orElse(null);
        if(userEntity==null){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(UserMapper.mapToUserDto(userEntity),HttpStatus.OK);
        }
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        UserEntity userEntity = UserMapper.mapToUserEntity(userDto);
        userRepository.save(userEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")String userID){
        userRepository.deleteById(userID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id")String userID,@RequestBody UserDto userDto){
        UserEntity newUser = UserMapper.mapToUserEntity(userDto);
        newUser.setId(userID);
        userRepository.save(newUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
