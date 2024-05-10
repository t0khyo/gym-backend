package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealRepository extends JpaRepository<Meal, UUID> {
}
