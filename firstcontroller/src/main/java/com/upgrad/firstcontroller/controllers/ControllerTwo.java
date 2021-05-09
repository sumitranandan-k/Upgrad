package com.upgrad.firstcontroller.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "controllertwo")
public class ControllerTwo {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloController(){
        return "Hello from new controller";
    }

    @RequestMapping(value = "/hello/hi")
    public @ResponseBody
    ResponseEntity TesterClass(){
        return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
    }
}
