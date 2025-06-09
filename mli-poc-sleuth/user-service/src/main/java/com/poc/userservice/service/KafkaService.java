package com.poc.userservice.service;

import com.poc.userservice.dto.UserRequest;

public interface KafkaService {

    void sendUserData(UserRequest user);
}
