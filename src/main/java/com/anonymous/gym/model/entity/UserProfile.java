package com.anonymous.gym.model.entity;

import com.anonymous.gym.model.entity.enums.DietGoal;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserProfile {
    private String firstName;

    private String lastName;

    private DietGoal goal;

    private LocalDate dob;

    private int weight;

    private int height;
}
