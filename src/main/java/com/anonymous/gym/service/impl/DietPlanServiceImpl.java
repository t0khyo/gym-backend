package com.anonymous.gym.service.impl;

import com.anonymous.gym.mapper.DietPlanMapper;
import com.anonymous.gym.model.DTO.DietPlanResponse;
import com.anonymous.gym.model.entity.DietPlan;
import com.anonymous.gym.model.entity.DietPlanType;
import com.anonymous.gym.model.entity.Meal;
import com.anonymous.gym.model.entity.User;
import com.anonymous.gym.repository.DietPlanRepository;
import com.anonymous.gym.repository.UserRepository;
import com.anonymous.gym.service.DietPlanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DietPlanServiceImpl implements DietPlanService {

    private final UserRepository userRepository;
    private final DietPlanRepository dietPlanRepository;
    private final DietPlanMapper dietPlanMapper;

    @Override
    public DietPlanResponse generateDietPlan(UUID userId, float bmi) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        DietPlanType dietPlanType;
        if (bmi < 18) {
            dietPlanType = DietPlanType.underweight;
        } else if (bmi > 18 && bmi < 25) {
            dietPlanType = DietPlanType.healthy_weight;
        } else {
            dietPlanType = DietPlanType.overweight;
        }
        Optional<DietPlan> dietPlan = dietPlanRepository.findByType(dietPlanType);

        if (dietPlan.isPresent()) {
            user.getUserProfile().setDietPlan(dietPlan.get());
            return dietPlanMapper.toDto(dietPlan.get());
        }

        return null;
    }



    @Override
    public DietPlanResponse getUserDietPlan(UUID userId) {

        return dietPlanMapper.toDto(null);
    }

    private List<Meal> generateSampleMealPlan(float dailyCalories) {
        // Implement logic to generate meals based on daily calorie intake
        return new ArrayList<>(); // Replace with actual meal generation
    }
}
