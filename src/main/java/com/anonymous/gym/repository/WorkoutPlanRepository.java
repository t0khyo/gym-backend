package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.User;
import com.anonymous.gym.model.entity.WorkoutPlan;
import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, UUID> {

    List<WorkoutPlan> findByDifficulty(ExerciseDifficulty difficulty);
}
