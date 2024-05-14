package com.anonymous.gym.model.DTO;

import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record WorkoutPlanResponse(
        String description,
        ExerciseDifficulty difficulty,
        List<ExerciseResponse> exercises
) {
}
