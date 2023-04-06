package com.elayachiabdelmajid.libMaroc.auth.services;

import com.elayachiabdelmajid.libMaroc.auth.entities.User;
import com.elayachiabdelmajid.libMaroc.auth.entities.types.Role;
import com.elayachiabdelmajid.libMaroc.auth.payload.responses.AuthResponse;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.auth.LoginRequest;
import com.elayachiabdelmajid.libMaroc.auth.payload.requests.auth.RegisterRequest;
import com.elayachiabdelmajid.libMaroc.auth.repositories.UserRepository;
import com.elayachiabdelmajid.libMaroc.security.JWTService;
import lombok.Builder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest) {
        // check if user already exists
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("User already exists");
        }
        var user = User.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
