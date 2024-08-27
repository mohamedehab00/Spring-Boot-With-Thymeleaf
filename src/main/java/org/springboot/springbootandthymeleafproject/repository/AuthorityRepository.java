package org.springboot.springbootandthymeleafproject.repository;

import org.springboot.springbootandthymeleafproject.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
