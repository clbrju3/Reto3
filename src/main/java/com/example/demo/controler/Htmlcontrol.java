package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Htmlcontrol {
    @Controller
    public class UserController {

        @GetMapping("/")
        public String index() {
            return "index";
        }
    }
}
