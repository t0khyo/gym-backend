package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, UUID> {
}
