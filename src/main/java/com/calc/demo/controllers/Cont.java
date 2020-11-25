package com.calc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Cont {

    public class Functions {
        @RequestMapping("/")
        public String getHomepage() {
            return "index";
        }
    }
}
