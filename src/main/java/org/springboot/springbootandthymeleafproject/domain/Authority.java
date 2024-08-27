package org.springboot.springbootandthymeleafproject.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authorities")
@Data
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String authority;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.id = null;
        this.username = username;
        this.authority = authority;
    }
}
