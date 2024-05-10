package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
}
