package com.anonymous.gym.model.DTO;

import lombok.Builder;

@Builder
public record NutrientsDto(
        int protein,
        int carbs,
        int fats
) {
}
