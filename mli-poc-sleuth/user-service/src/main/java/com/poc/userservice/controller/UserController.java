package com.poc.userservice.controller;

import com.poc.userservice.dto.UserRequest;
import com.poc.userservice.service.KafkaService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final KafkaService kafkaService;

    public UserController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserRequest user) {
        kafkaService.sendUserData(user);
        return ResponseEntity.ok("User data sent successfully!");
    }
}
