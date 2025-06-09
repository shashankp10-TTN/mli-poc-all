package com.poc.employeeservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.employeeservice.dto.EmployeeRequest;
import com.poc.employeeservice.dto.UserRequest;
import com.poc.employeeservice.service.EmployeeService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String TOPIC = "employee";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public EmployeeServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void consumerUserData(UserRequest user)  {
        try {
            EmployeeRequest employeeRequest = createEmployeeRequest(user);
            String employeeJson = objectMapper.writeValueAsString(employeeRequest);
            kafkaTemplate.send(TOPIC, employeeRequest.getEmployeeId(), employeeJson );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private EmployeeRequest createEmployeeRequest(UserRequest user) {
       return EmployeeRequest.builder()
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .contactNo(user.getContactNo())
                .competency("JVM")
                .projectName("Adobe")
                .trackName("MLI-MPro")
                .employeeId(generateEmployeeId(user.getEmail(), user.getContactNo()))
                .build();
    }

    private String generateEmployeeId(String email, String contactNo) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        random.setSeed(email.hashCode());
        random.setSeed(contactNo.hashCode());
        return String.valueOf(Math.abs(random.nextInt()));
    }
}
