package com.anonymous.gym.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private LocalDate dob;

    private float weight;

    private int height;

    private float bmi;

    @ManyToOne
    @JoinColumn(name="workout_plan_id")
    private WorkoutPlan workoutPlan;


    @ManyToOne
    @JoinColumn(name="diet_plan_id")
    private DietPlan dietPlan;
}
