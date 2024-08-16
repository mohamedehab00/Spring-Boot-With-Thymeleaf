package org.springboot.springbootandthymeleafproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("serverTime", LocalDateTime.now());
        return "index";
    }
}
