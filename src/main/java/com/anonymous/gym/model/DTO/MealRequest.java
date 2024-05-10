package com.anonymous.gym.model.DTO;

import com.anonymous.gym.model.entity.enums.MealType;
import lombok.Builder;

@Builder
public record MealRequest(
        String name,
        String description,
        MealType type,
        int calories,
        NutrientsDto nutrients
) {
}
