package com.example.firstproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @RequestMapping(value="/api/basic", method = RequestMethod.POST)
    public String getRestRes(String req){
        return "{\"seq\":\"1\", \"value\":\"222\"}";
    }
}
