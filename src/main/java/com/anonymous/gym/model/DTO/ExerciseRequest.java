package com.anonymous.gym.model.DTO;

import lombok.Builder;

@Builder
public record ExerciseRequest(
        String name,
        String description,
        int reps,
        String gifUrl
) {
}
