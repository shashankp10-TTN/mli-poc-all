package com.poc.dbservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.dbservice.dto.EmployeeRequest;
import com.poc.dbservice.service.EmployeeService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

    private final String TOPIC = "employee";
    private final String GROUP_ID = "employee-group";

    private final ObjectMapper objectMapper;
    private final EmployeeService employeeService;

    public DBController(ObjectMapper objectMapper, EmployeeService employeeService) {
        this.objectMapper = objectMapper;
        this.employeeService = employeeService;
    }

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consumeEmployeeData(String employeeRequest) {
        try {
            EmployeeRequest employeeData = objectMapper.readValue(employeeRequest, EmployeeRequest.class);
            employeeService.saveEmployee(employeeData);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
}
