package com.ms.user.service.UserService.controller;

import com.ms.user.service.UserService.entities.User;
import com.ms.user.service.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUer(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getALlUser() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);

    }
}
