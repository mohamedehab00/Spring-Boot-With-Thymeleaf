package org.springboot.springbootandthymeleafproject.repository;

import org.springboot.springbootandthymeleafproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
