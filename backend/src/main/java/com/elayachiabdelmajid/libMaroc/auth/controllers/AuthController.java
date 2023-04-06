package com.elayachiabdelmajid.libMaroc.auth.controllers;

import com.elayachiabdelmajid.libMaroc.auth.payload.requests.auth.LoginRequest;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.auth.RegisterRequest;
import com.elayachiabdelmajid.libMaroc.auth.services.AuthService;
import com.elayachiabdelmajid.libMaroc.auth.payload.responses.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
