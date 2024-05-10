package com.anonymous.gym.model.DTO;

import com.anonymous.gym.model.entity.enums.MealType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record MealResponse(
        UUID id,
        String name,
        String description,
        MealType type,
        int calories,
        NutrientsDto nutrients
) {
}
