package com.anonymous.gym.service;

import com.anonymous.gym.model.DTO.DietPlanResponse;

import java.util.UUID;

public interface DietPlanService {
    DietPlanResponse generateDietPlan(UUID userId, float bmi);
    DietPlanResponse getUserDietPlan(UUID userId);
}
