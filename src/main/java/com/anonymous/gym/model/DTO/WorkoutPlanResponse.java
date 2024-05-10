package com.anonymous.gym.model.DTO;

import lombok.Builder;

import java.util.List;

@Builder
public record WorkoutPlanResponse(
        String description,
        List<ExerciseResponse> exercises
) {
}
