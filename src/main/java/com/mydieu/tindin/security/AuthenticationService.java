package com.mydieu.tindin.security;

import com.mydieu.tindin.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisteredRequest request) {
        // var user = new User();
        // user.setFirstName(request.getFirstName());
        // user.setLastName(request.getLastName());
        // user.setEmail(request.getEmail());
        // user.setPassword(passwordEncoder.encode(request.getPassword()));
        // user.setRole(request.getRole());
        // repository.save(user);
        // var jwtToken = jwtService.generateToken(user);
        // return new AuthenticationResponse(jwtToken);
        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // authenticationManager.authenticate(
        //         new UsernamePasswordAuthenticationToken(
        //                 request.getUsername(),
        //                 request.getPassword()
        //         )
        // );
        // var user = repository.findByUsername(request.getUsername())
        //         .orElseThrow();
        // var jwtToken = jwtService.generateToken(user);
        // return new AuthenticationResponse(jwtToken);
        return null;
    }
}
