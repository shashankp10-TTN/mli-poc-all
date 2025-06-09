package com.poc.emailservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.emailservice.dto.EmployeeRequest;
import com.poc.emailservice.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final String TOPIC = "employee";
    private final String GROUP_ID = "employee-group";

    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public EmailController(ObjectMapper objectMapper, EmailService emailService) {
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consumeEmployeeData(String employeeRequest) {
        System.out.println("Inside consumeEmployeeData method`");
        try {
            EmployeeRequest employeeData = objectMapper.readValue(employeeRequest, EmployeeRequest.class);
            System.out.println("Employee Data : " + employeeData);
            String employeeEmail = employeeData.getEmail();
            emailService.sendEmail(employeeEmail, employeeData.getName());
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
}
