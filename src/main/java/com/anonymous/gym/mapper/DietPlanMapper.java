package com.anonymous.gym.mapper;

import com.anonymous.gym.model.DTO.DietPlanResponse;
import com.anonymous.gym.model.entity.DietPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface DietPlanMapper {
    DietPlanResponse toDto(DietPlan dietPlan);
}
