package com.anonymous.gym.model.DTO;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ExerciseResponse(
        UUID id,
        String name,
        String description,
        int reps,
        String gifUrl
) {
}
