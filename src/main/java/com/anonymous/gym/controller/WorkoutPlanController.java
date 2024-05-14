package com.anonymous.gym.controller;

import com.anonymous.gym.model.DTO.WorkoutPlanRequest;
import com.anonymous.gym.model.DTO.WorkoutPlanResponse;
import com.anonymous.gym.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/v1/api/workouts")
@RestController
public class WorkoutPlanController {
    private final WorkoutPlanService workoutPlanService;

//    @PostMapping()
//    public ResponseEntity<WorkoutPlanResponse> postWorkoutPlan(@RequestBody WorkoutPlanRequest workoutPlanRequest) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(workoutPlanService.saveWorkoutPlan(workoutPlanRequest));
//    }
}
