package com.anonymous.gym.model.DTO;

import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import lombok.Builder;

import java.util.List;

@Builder
public record WorkoutPlanRequest(
        String description,
        ExerciseDifficulty difficulty,
        List<ExerciseResponse> exercises
) {
}
