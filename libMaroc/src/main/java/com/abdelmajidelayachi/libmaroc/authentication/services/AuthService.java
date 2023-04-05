package com.abdelmajidelayachi.libmaroc.authentication.services;

import com.abdelmajidelayachi.libmaroc.authentication.dto.requests.auth.LoginRequest;
import com.abdelmajidelayachi.libmaroc.authentication.dto.requests.auth.RegisterRequest;
import com.abdelmajidelayachi.libmaroc.authentication.dto.responses.AuthResponse;
import com.abdelmajidelayachi.libmaroc.authentication.entities.User;
import com.abdelmajidelayachi.libmaroc.authentication.entities.types.Role;
import com.abdelmajidelayachi.libmaroc.authentication.repositories.UserRepository;
import com.abdelmajidelayachi.libmaroc.security.JWTService;
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
