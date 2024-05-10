package com.anonymous.gym.mapper;

import com.anonymous.gym.model.DTO.MealRequest;
import com.anonymous.gym.model.DTO.MealResponse;
import com.anonymous.gym.model.entity.Meal;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface MealMapper {
    Meal toEntity(MealRequest MealRequestDto);

    MealResponse toDto(Meal meal);
}
