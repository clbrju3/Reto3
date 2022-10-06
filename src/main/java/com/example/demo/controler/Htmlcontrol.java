package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Htmlcontrol {
        @GetMapping("/")
        public String index() {
            return "index";
        }
    }

