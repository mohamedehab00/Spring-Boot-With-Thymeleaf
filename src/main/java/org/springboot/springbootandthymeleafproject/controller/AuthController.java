package org.springboot.springbootandthymeleafproject.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springboot.springbootandthymeleafproject.domain.User;
import org.springboot.springbootandthymeleafproject.service.serviceInterface.AuthService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Getter
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {
        return "access-denied";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerNewUser(
            @ModelAttribute("user")
            @Valid
            User user,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "redirect:/register?failed";
        }

        authService.registerUser(user);

        return "redirect:/login";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);

        binder.registerCustomEditor(String.class, editor);
    }
}
