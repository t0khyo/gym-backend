package com.anonymous.gym.mapper;

import com.anonymous.gym.model.DTO.ExerciseRequest;
import com.anonymous.gym.model.DTO.ExerciseResponse;
import com.anonymous.gym.model.entity.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ExerciseMapper {
    Exercise toEntity(ExerciseRequest exerciseRequestDto);
    ExerciseResponse toDto(Exercise exercise);
}
