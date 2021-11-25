package com.wildcodeschool.myProjectWithSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String text() {
        return "Welcome to the SHIELD!!!";
    }
    @GetMapping("/avengers/assemble")
    public String heroes() {
        return "Avengers..... Assemble";
    }

    @GetMapping("/secretbases")
    public String director() {
        return "Berlin, Barcelona, Brüssel, ...";
    }
}
