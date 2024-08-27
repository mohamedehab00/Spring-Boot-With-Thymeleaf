package org.springboot.springbootandthymeleafproject.service.serviceImpl;

import lombok.Getter;
import lombok.Setter;
import org.springboot.springbootandthymeleafproject.domain.Authority;
import org.springboot.springbootandthymeleafproject.domain.User;
import org.springboot.springbootandthymeleafproject.repository.UserRepository;
import org.springboot.springbootandthymeleafproject.service.serviceInterface.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Setter
@Getter
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void registerUser(User user) {
        user.setPassword(STR."{bcrypt}\{getEncoder().encode(user.getPassword())}");

        user.setEnabled(1);

        user.setAuthoritySet(new HashSet<>());

        user.getAuthoritySet().add(new Authority(user.getUsername(), "ROLE_EMPLOYEE"));

        getUserRepository().save(user);
    }
}
