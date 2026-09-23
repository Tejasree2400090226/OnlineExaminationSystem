package com.klu.auth.config;

import com.klu.auth.entity.User;
import com.klu.auth.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner createUsers(UserRepository userRepository,
                                   PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByUsername("admin").isEmpty()) {

                User admin = new User(
                        "admin",
                        passwordEncoder.encode("admin123"),
                        "ADMIN"
                );

                userRepository.save(admin);
            }

            if (userRepository.findByUsername("student").isEmpty()) {

                User student = new User(
                        "student",
                        passwordEncoder.encode("student123"),
                        "STUDENT"
                );

                userRepository.save(student);
            }
        };
    }
}