package org.springboot.springbootandthymeleafproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "email", unique = true)
    private String email;
}
