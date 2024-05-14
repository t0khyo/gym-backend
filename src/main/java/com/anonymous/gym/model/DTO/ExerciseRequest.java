package com.anonymous.gym.model.DTO;

import com.anonymous.gym.model.entity.enums.ExerciseType;
import com.anonymous.gym.model.entity.enums.Muscle;
import lombok.Builder;

@Builder
public record ExerciseRequest(
        String name,

        ExerciseType type,

        String equipment,

        Muscle muscle,

        String instructions,

        String gifUrl
) {
}
