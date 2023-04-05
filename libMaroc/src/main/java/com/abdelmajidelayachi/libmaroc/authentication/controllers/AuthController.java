package com.abdelmajidelayachi.libmaroc.authentication.controllers;

import com.abdelmajidelayachi.libmaroc.authentication.dto.requests.auth.LoginRequest;
import com.abdelmajidelayachi.libmaroc.authentication.dto.requests.auth.RegisterRequest;
import com.abdelmajidelayachi.libmaroc.authentication.dto.responses.AuthResponse;
import com.abdelmajidelayachi.libmaroc.authentication.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest registerRequest){
        return ResponseEntity.ok(authService.login(registerRequest));
    }

}
