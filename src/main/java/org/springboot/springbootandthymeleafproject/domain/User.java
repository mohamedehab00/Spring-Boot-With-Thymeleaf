package org.springboot.springbootandthymeleafproject.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
@RequiredArgsConstructor
public class User {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Id
    private String username;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    @JdbcType(TinyIntJdbcType.class)
    private int enabled;

    @OneToMany(mappedBy = "username", cascade = CascadeType.ALL)
    private Set<Authority> authoritySet;
}
