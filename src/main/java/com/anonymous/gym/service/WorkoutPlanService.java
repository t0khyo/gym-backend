package com.anonymous.gym.service;

import com.anonymous.gym.model.DTO.ExerciseResponse;
import com.anonymous.gym.model.DTO.WorkoutPlanRequest;
import com.anonymous.gym.model.DTO.WorkoutPlanResponse;
import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;

import java.util.UUID;

public interface WorkoutPlanService extends BaseService<WorkoutPlanResponse ,WorkoutPlanRequest> {
    WorkoutPlanResponse generateWorkoutPlan(UUID userId, ExerciseDifficulty difficulty);
    WorkoutPlanResponse getUserWorkoutPlan(UUID userId);

//    WorkoutPlanResponse saveWorkoutPlan(WorkoutPlanRequest workoutPlanRequest);
}
