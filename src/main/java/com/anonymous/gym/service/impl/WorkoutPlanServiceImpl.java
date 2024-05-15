package com.anonymous.gym.service.impl;

import com.anonymous.gym.mapper.WorkoutPlanMapper;
import com.anonymous.gym.model.DTO.WorkoutPlanRequest;
import com.anonymous.gym.model.DTO.WorkoutPlanResponse;
import com.anonymous.gym.model.entity.User;
import com.anonymous.gym.model.entity.WorkoutPlan;
import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import com.anonymous.gym.repository.ExerciseRepository;
import com.anonymous.gym.repository.UserRepository;
import com.anonymous.gym.repository.WorkoutPlanRepository;
import com.anonymous.gym.service.WorkoutPlanService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WorkoutPlanServiceImpl implements WorkoutPlanService {
    private final WorkoutPlanRepository workoutPlanRepository;
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;
    private final WorkoutPlanMapper workoutPlanMapper;


    @Transactional
    @Override
    public WorkoutPlanResponse generateWorkoutPlan(UUID userId, ExerciseDifficulty difficulty) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        WorkoutPlan workoutPlan = this.getRandomWorkoutPlanByDifficulty(difficulty);
        user.getUserProfile().setWorkoutPlan(workoutPlan);

        return workoutPlanMapper.toDto(workoutPlan);
    }

    private WorkoutPlan getRandomWorkoutPlanByDifficulty(ExerciseDifficulty difficulty) {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findByDifficulty(difficulty);

        if (workoutPlans.isEmpty()) {
            throw new EntityNotFoundException("No Workout plan found for the specified difficulty level: " + difficulty);
        }

        return workoutPlans.get(new Random().nextInt(workoutPlans.size()));
    }


    @Override
    public WorkoutPlanResponse getUserWorkoutPlan(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        return workoutPlanMapper.toDto(user.getUserProfile().getWorkoutPlan());
    }

    public List<WorkoutPlanResponse> getAll() {
        return workoutPlanRepository.findAll().stream()
                .collect(Collectors.toList(WorkoutPlanMapper::toDto));
    }


    @Override
    public WorkoutPlanResponse getById(UUID id) {
        return null;
    }

    @Override
    public WorkoutPlanResponse create(WorkoutPlanRequest entity) {
        return null;
    }

    @Override
    public WorkoutPlanResponse update(WorkoutPlanRequest entity) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
