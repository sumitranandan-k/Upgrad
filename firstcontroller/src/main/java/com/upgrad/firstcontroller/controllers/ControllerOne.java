package com.upgrad.firstcontroller.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "controllerone")
/**
 * 127.0.0.1:8080/controllerone
 */
public class ControllerOne {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String helloController(){
        return "Hello from @RESTController";
    }

    @RequestMapping(value = "/hello/hi")
    public @ResponseBody
    ResponseEntity TesterClass(){
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }
}
