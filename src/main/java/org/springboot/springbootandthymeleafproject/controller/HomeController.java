package org.springboot.springbootandthymeleafproject.controller;

import jakarta.validation.Valid;
import org.springboot.springbootandthymeleafproject.domain.User;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    List<String> countries = Arrays
            .stream(new String[]{"Egypt", "France", "Holland"})
            .toList();

    List<String> languages = Arrays
            .stream(new String[]{"Java", "C++", "Python"})
            .toList();

    List<String> OSs = Arrays
            .stream(new String[]{"Linux", "Ubuntu", "Kali"})
            .toList();

    @GetMapping("")
    public String getHome(Model model) {
        model.addAttribute("serverTime", LocalDateTime.now());
        return "home";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("countriesList", countries);
        model.addAttribute("languagesList", languages);
        model.addAttribute("OSsList", OSs);

        model.addAttribute("user", new User());

        return "form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid
            @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model) {

        model.addAttribute("user", user);

        if (bindingResult.hasErrors()) {
            model.addAttribute("countriesList", countries);
            model.addAttribute("languagesList", languages);
            model.addAttribute("OSsList", OSs);

            return "form";
        }

        return "formConfirmation";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);

        binder.registerCustomEditor(String.class, editor);
    }
}
