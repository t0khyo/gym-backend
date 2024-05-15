package com.anonymous.gym.controller;

import com.anonymous.gym.model.DTO.DietPlanResponse;
import com.anonymous.gym.model.DTO.WorkoutPlanResponse;
import com.anonymous.gym.model.entity.User;
import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import com.anonymous.gym.service.DietPlanService;
import com.anonymous.gym.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    private final DietPlanService dietPlanService;
    private final WorkoutPlanService workoutPlanService;

    @PostMapping("/diet")
    public ResponseEntity<DietPlanResponse> generateUserDietPlan(
            @RequestParam float bmi
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UUID userId = ((User)authentication.getPrincipal()).getId();

        return ResponseEntity.ok(dietPlanService.generateDietPlan(userId, bmi));
    }

    @GetMapping("/diet")
    public ResponseEntity<DietPlanResponse> getUserDietPlan() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UUID userId = ((User)authentication.getPrincipal()).getId();

        return ResponseEntity.ok(dietPlanService.getUserDietPlan(userId));
    }

    @PostMapping("/workout")
    public ResponseEntity<WorkoutPlanResponse> generateWorkoutPlan(
            @RequestParam ExerciseDifficulty difficulty
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UUID userId = ((User)authentication.getPrincipal()).getId();

        return ResponseEntity.ok(workoutPlanService.generateWorkoutPlan(userId, difficulty));
    }

    @GetMapping("/workout")
    public ResponseEntity<WorkoutPlanResponse> getUserWorkoutPlan() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UUID userId = ((User)authentication.getPrincipal()).getId();

        return ResponseEntity.ok(workoutPlanService.getUserWorkoutPlan(userId));
    }


}
