package com.poc.userservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.userservice.dto.UserRequest;
import com.poc.userservice.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KakfaServiceImpl implements KafkaService {

    private static final String TOPIC = "user";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KakfaServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendUserData(UserRequest userData) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(userData.getPassword());
            userData.setPassword(encodedPassword);
            String json = objectMapper.writeValueAsString(userData);
            System.out.println("Sent user data : " + json);
            kafkaTemplate.send(TOPIC, userData.getEmail(), json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
