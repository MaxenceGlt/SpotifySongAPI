package com.app.LOLEsport_Back.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellWorld {

    @GetMapping(value = "/test")
    public String test(){
        return "Hello World";
}

}
