package com.upgrad.firstcontroller.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/home","/home2"})
public class TestController {


    @RequestMapping(value= {"/sayHello"})
    public String sayHello(){
        return "Hello";
    }

    @GetMapping(value= {"/sayBye"})
    public String sayBye(){
        return "Bye";
    }

    @GetMapping("/movies/{movieId}")
    public String getMovieDetails
            (@PathVariable(name = "movieId") int id){
        return "Hola_"+ id;
    }
}