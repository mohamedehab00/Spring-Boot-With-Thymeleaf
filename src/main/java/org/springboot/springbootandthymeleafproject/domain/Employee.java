package org.springboot.springbootandthymeleafproject.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "second_name")
    private String secondName;
    @NotNull(message = "is required")
    @Email(message = "must be a valid email")
    @Column(name = "email", unique = true)
    private String email;
}
