package com.anonymous.gym.model.DTO;

import com.anonymous.gym.model.entity.enums.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpRequest {
    private String email;

    private String password;

    private Role role;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private float weight;

    private int height;

    private float bmi;

}
