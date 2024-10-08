package org.springboot.springbootandthymeleafproject.service.serviceInterface;

import org.springboot.springbootandthymeleafproject.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void saveEmployee(Employee employee);

    Employee updateEmployeeById(Employee employee);

    void deleteEmployeeById(Long id);
}
