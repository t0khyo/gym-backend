package com.anonymous.gym.service.impl;

import com.anonymous.gym.mapper.DietPlanMapper;
import com.anonymous.gym.model.DTO.DietPlanResponse;
import com.anonymous.gym.model.entity.DietPlan;
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

        int dailyCalories = calculateDailyCalories(user);

        List<Meal> meals = generateSampleMealPlan(dailyCalories);

        DietPlan dietPlan = DietPlan.builder()
                .user(user)
                .dailyCalories(dailyCalories)
                .meals(meals)
                .build();

        dietPlanRepository.save(dietPlan);

        return dietPlanMapper.toDto(dietPlan);
    }

    private int calculateDailyCalories(User user) {
        int age = LocalDate.now().getYear() - user.getUserProfile().getDob().getYear();
        float weight = user.getUserProfile().getWeight();

        float bmr = 10
                * user.getUserProfile().getWeight()
                + 6.25f
                * weight
                - 5
                * age;

        float activityFactor = 1.2f;

//        if (user.getUserProfile().getGoal() == DietGoal.LOSE_WEIGHT) {
//            activityFactor *= 0.8f;     // Reduce slightly for weight loss
//        } else if (user.getUserProfile().getGoal() == DietGoal.GAIN_MUSCLE) {
//            activityFactor *= 1.3f;     // Increase slightly for muscle gain
//        }

        return Math.round(bmr * activityFactor);
    }

    private float calculateBMI(float weightInKg, int heightInMeters) {
        if (heightInMeters <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative");
        }

        return weightInKg / (heightInMeters * heightInMeters);
    }

    @Override
    public DietPlanResponse getUserDietPlan(UUID userId) {
        DietPlan dietPlan = dietPlanRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Diet plan not found for user with id: " + userId));

        return dietPlanMapper.toDto(dietPlan);
    }

    private List<Meal> generateSampleMealPlan(float dailyCalories) {
        // Implement logic to generate meals based on daily calorie intake
        return new ArrayList<>(); // Replace with actual meal generation
    }
}
