package com.anonymous.gym.model.DTO;

import lombok.Builder;

import java.util.List;

@Builder
public record DietPlanResponse(
        String description,
        int dailyCalories,
        List<MealResponse> meals
) {
}
