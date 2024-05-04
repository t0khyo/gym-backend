package com.anonymous.gym.model.DTO;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}

