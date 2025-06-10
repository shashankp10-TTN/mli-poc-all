package com.poc.employeeservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.employeeservice.dto.UserRequest;
import com.poc.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final ObjectMapper objectMapper;
    private final EmployeeService employeeService;

    public EmployeeController(ObjectMapper objectMapper,  EmployeeService employeeService) {
        this.objectMapper = objectMapper;
        this.employeeService = employeeService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumerUserData(String userData) {
        try {
            UserRequest userRequest = objectMapper.readValue(userData, UserRequest.class);
            employeeService.consumerUserData(userRequest);
        } catch(JsonProcessingException ex) {
            ex.printStackTrace();
        }

    }
}
