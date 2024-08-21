package org.springboot.springbootandthymeleafproject.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springboot.springbootandthymeleafproject.domain.Employee;
import org.springboot.springbootandthymeleafproject.service.serviceInterface.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
@Getter
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("")
    public String retrieveAllEmployees(Model model) {
        List<Employee> employees = getEmployeeService().getAllEmployees();

        model.addAttribute("employeesList", employees);

        return "employees";
    }
}
