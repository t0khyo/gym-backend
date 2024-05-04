package com.anonymous.gym.service;


import com.anonymous.gym.model.DTO.JwtAuthenticationResponse;
import com.anonymous.gym.model.DTO.RefreshTokenRequest;
import com.anonymous.gym.model.DTO.SignInRequest;
import com.anonymous.gym.model.DTO.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SignInRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
