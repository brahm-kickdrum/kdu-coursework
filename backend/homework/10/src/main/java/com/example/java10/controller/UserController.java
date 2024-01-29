package com.example.java10.controller;

import com.example.java10.model.User;
import com.example.java10.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> person = userService.getAllUsers();
        log.info("Users shown successfully!!");
        return ResponseEntity.ok(person);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName) {
        Optional<User> user = userService.getUserByName(userName);

        if (user.isPresent()) {
            log.info("User shown!!");
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userService.addUser(user);
        log.info("Added user!!");
        return ResponseEntity.ok().build();
    }
}
