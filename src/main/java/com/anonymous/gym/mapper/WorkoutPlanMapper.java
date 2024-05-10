package com.anonymous.gym.mapper;

import com.anonymous.gym.model.DTO.WorkoutPlanResponse;
import com.anonymous.gym.model.entity.WorkoutPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface WorkoutPlanMapper {
    WorkoutPlanResponse toDto(WorkoutPlan workoutPlan);
}