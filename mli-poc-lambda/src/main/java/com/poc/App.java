package com.poc;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class App implements RequestHandler<Map<String,Object>, String> {

    @Override
    public String handleRequest(Map<String, Object> stringObjectMap, Context context) {
        return "Hey! I'm Shashank Pandey... Printing this using AWS lambda";
    }
}
