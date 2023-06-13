package com.mydieu.tindin.security;

import com.mydieu.tindin.repositories.UserRepository;

import com.mydieu.tindin.models.Account;
import com.mydieu.tindin.models.User;
import com.mydieu.tindin.repositories.AccountRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, AccountRepository accountRepository,
                                 PasswordEncoder passwordEncoder, JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
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
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Account account = accountRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User user = userRepository.findById(account.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Generate JWT token for the authenticated user
        String token = jwtService.generateToken(account);

        // Create the AuthenticationResponse with the token, userId, and role
        AuthenticationResponse response = new AuthenticationResponse(token, user.getId(), user.getRole().name());

        // Return the AuthenticationResponse
        return response;
    }
}
