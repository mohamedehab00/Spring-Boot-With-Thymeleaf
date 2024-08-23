package org.springboot.springbootandthymeleafproject.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springboot.springbootandthymeleafproject.domain.Employee;
import org.springboot.springbootandthymeleafproject.service.serviceInterface.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employeeForm")
    public String employeeForm(Model model) {

        Object obj = model.getAttribute("employee");

        Employee employee;

        if (obj == null) {
            employee = new Employee();
        } else {
            employee = (Employee) obj;
        }

        model.addAttribute("employee", employee);

        return "form";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") Long id, Model model) {
        Employee employee = getEmployeeService().getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id) {

        getEmployeeService().deleteEmployeeById(id);

        return "redirect:/employees";
    }

    @PostMapping("processEmployee")
    public String processAddingEmployee(
            @Valid
            @ModelAttribute("employee")
            Employee employee,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        getEmployeeService().saveEmployee(employee);

        return "redirect:/employees/employeeForm";
    }
}
