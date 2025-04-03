package com.petclinic.practice;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String sayHi() {
        return "Hello John";
    }
}