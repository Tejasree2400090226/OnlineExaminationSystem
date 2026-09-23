package com.klu.auth.controller;

import com.klu.auth.dto.LoginRequest;
import com.klu.auth.dto.LoginResponse;
import com.klu.auth.entity.User;
import com.klu.auth.repository.UserRepository;
import com.klu.auth.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponse(
                token,
                user.getUsername(),
                user.getRole()
        );
    }
}