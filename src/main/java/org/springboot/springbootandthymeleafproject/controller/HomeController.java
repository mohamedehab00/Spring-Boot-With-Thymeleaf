package org.springboot.springbootandthymeleafproject.controller;

import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/form")
    public String getForm() {
        return "form";
    }

    @GetMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {
        model.addAttribute("name", request.getParameter("name"));
        model.addAttribute("email", request.getParameter("email"));
        return "formConfirmation";
    }
}
