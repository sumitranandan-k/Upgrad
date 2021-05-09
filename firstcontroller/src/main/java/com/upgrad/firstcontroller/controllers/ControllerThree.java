package com.upgrad.firstcontroller.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"controllerthree1", "controllerthree2"})
public class ControllerThree {

    @GetMapping(value = {"hello", "hi"})
    public String helloController(){
        return "hello from multi URI controller";
    }
}
