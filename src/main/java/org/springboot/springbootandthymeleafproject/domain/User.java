package org.springboot.springbootandthymeleafproject.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springboot.springbootandthymeleafproject.validationAnnotation.CourseCode;

@Data
public class User {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    private String email;
    @NotNull(message = "is required")
    @Min(value = 18, message = "eligible from 18 to 50")
    @Max(value = 50, message = "eligible from 18 to 50")
    private Integer age;
    private String country;
    private String favouriteLang;
    private String favouriteOs;
    @CourseCode()
    private String courseCode;
}
