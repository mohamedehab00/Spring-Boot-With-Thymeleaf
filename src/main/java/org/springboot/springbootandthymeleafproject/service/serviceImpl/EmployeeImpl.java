package org.springboot.springbootandthymeleafproject.service.serviceImpl;

import lombok.Getter;
import org.springboot.springbootandthymeleafproject.domain.Employee;
import org.springboot.springbootandthymeleafproject.repository.EmployeeRepository;
import org.springboot.springbootandthymeleafproject.service.serviceInterface.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Getter
public class EmployeeImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeImpl(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = getEmployeeRepository().findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee Not Found");
        }

        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getEmployeeRepository().findAllByOrderByFirstNameAscSecondNameAsc();
    }

    @Override
    public void saveEmployee(Employee employee) {
        getEmployeeRepository().save(employee);
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {
        Optional<Employee> optionalExistingEmployee = getEmployeeRepository().findById(employee.getId());

        if (optionalExistingEmployee.isEmpty()) {
            throw new RuntimeException("Employee Not Found");
        }

        Employee existingEmployee = optionalExistingEmployee.get();

        if (StringUtils.hasText(employee.getFirstName())) {
            employee.setFirstName(employee.getFirstName());
        }
        if (StringUtils.hasText(employee.getSecondName())) {
            employee.setSecondName(employee.getSecondName());
        }
        if (StringUtils.hasText(employee.getEmail())) {
            employee.setEmail(employee.getEmail());
        }

        existingEmployee = getEmployeeRepository().save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Optional<Employee> employee = getEmployeeRepository().findById(id);

        if (employee.isEmpty()) {
            throw new RuntimeException("Employee Not Found");
        }

        getEmployeeRepository().delete(employee.get());
    }
}
