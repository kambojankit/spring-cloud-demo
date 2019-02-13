package com.techarha.demo.user.controller;

import com.techarha.demo.user.model.User;
import com.techarha.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity createUser(@Validated @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {
        List<User> userList = userRepository.findByNameContaining(name);
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @GetMapping("/search/username/{userName}")
    public ResponseEntity<List<User>> getUserByUserName(@PathVariable String userName) {
        List<User> userList = userRepository.findByUserNameContaining(userName);
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@Validated @RequestBody User user) {
        User c = userRepository.save(user);
        return new ResponseEntity(c.getId(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
