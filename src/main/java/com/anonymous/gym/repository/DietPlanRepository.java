package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.DietPlan;
import com.anonymous.gym.model.entity.DietPlanType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DietPlanRepository extends JpaRepository<DietPlan, UUID> {
    Optional<DietPlan> findByType(DietPlanType dietPlanType);
}
