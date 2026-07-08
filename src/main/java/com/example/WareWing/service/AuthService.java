package com.example.WareWing.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.WareWing.dto.AuthRequestDto;
import com.example.WareWing.dto.AuthResponseDto;
import com.example.WareWing.entity.SystemUserEntity;
import com.example.WareWing.exception.BusinessValidationException;
import com.example.WareWing.repository.SystemUserRepository;
import com.example.WareWing.util.JwtService;

@Service
public class AuthService {

    private final SystemUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(SystemUserRepository repository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public SystemUserEntity register(SystemUserEntity user) {

    if (repository.findByUsername(user.getUsername()).isPresent()) {
        throw new BusinessValidationException("Username already exists");
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return repository.save(user);
}

    public AuthResponseDto login(AuthRequestDto request) {

        SystemUserEntity user = repository.findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new BusinessValidationException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessValidationException("Invalid username or password");
        }

        String token = jwtService.generateToken(
                user.getUsername(),
                user.getRole().name());

        return new AuthResponseDto(
                token,
                user.getRole().name(),
                user.getUsername());
    }
}