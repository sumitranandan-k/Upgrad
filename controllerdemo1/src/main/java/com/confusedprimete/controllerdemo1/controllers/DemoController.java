package com.confusedprimete.controllerdemo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
/**
 * 127.0.0.1:8080/demo
 */
public class DemoController {

    @GetMapping("/hello")
    public @ResponseBody String welcomMessage(){
        System.out.println("welcomMessage called");
        return "Welcome to demo from @Controller demo with GetMapping";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public @ResponseBody String welcomMessage1(){
        System.out.println("welcomMessage called");
        return "Welcome to demo from @Controller demo with RequestMapping";
    }
}
