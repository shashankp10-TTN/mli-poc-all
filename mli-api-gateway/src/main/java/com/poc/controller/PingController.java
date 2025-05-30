package com.poc.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;


@RestController
@EnableWebMvc
public class PingController {
    @RequestMapping(path = "/api/v1/hello", method = RequestMethod.GET)
    public String ping() {
       return "Hey! I'm Shashank, POC using API Gateway....";
    }
}
