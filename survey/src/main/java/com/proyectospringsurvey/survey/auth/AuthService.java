package com.proyectospringsurvey.survey.auth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.jwt.JwtService;
import com.proyectospringsurvey.survey.users.domain.Role;
import com.proyectospringsurvey.survey.users.domain.Users;
import com.proyectospringsurvey.survey.users.infraestructure.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final JwtService jwtservice;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtservice.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
       
        Users user = Users.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtservice.getToken(user))
            .build();
        
    }

    

}
