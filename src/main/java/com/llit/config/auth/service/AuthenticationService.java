package com.llit.config.auth.service;

import com.llit.config.auth.AuthenticationRequest;
import com.llit.config.auth.AuthenticationResponse;
import com.llit.config.auth.RegisterRequest;
import com.llit.config.auth.ldap.User;
import com.llit.config.auth.ldap.UserRepository;
import com.llit.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = User.builder()
                .uid(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                request.getUserId(),
                request.getPassword()
        );

        authenticationManager.authenticate(auth);

        var user = userRepository.findByUid(request.getUserId());

        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .jwt(jwtToken)
                .build();
    }
}
