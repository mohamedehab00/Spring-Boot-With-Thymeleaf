package org.springboot.springbootandthymeleafproject.SecConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test456")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test789")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }*/

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/employees").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                        .requestMatchers("/employees/**").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/register**").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        ).logout(
                LogoutConfigurer::permitAll
        ).exceptionHandling(configurer ->
                configurer.accessDeniedPage("/access-denied")
        );

        return http.build();
    }
}
