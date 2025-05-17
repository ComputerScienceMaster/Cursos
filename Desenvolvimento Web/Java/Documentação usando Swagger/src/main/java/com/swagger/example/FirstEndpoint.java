package com.swagger.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstEndpoint {

    @GetMapping("/hello")
    public String getInformations(){
        return "Bom dia do primeiro endpoint";
    }
}
