package com.example.WareWing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.WareWing.dto.AuthRequestDto;
import com.example.WareWing.dto.AuthResponseDto;
import com.example.WareWing.service.AuthService;
import org.springframework.http.HttpStatus;
import com.example.WareWing.entity.SystemUserEntity;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    
    @PostMapping("/register")
    public ResponseEntity<SystemUserEntity> register(
        @RequestBody SystemUserEntity user) {

    return new ResponseEntity<>(
            authService.register(user),
            HttpStatus.CREATED);
}
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(
            @RequestBody AuthRequestDto request) {

        return ResponseEntity.ok(authService.login(request));
    }
}