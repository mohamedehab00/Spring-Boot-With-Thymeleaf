package org.springboot.springbootandthymeleafproject.repository;

import org.springboot.springbootandthymeleafproject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByOrderByFirstNameAscSecondNameAsc();
}
