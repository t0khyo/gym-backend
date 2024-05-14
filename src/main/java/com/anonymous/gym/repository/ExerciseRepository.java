package com.anonymous.gym.repository;

import com.anonymous.gym.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

    @Query(nativeQuery = true, value = "SELECT * FROM exercise ORDER BY random() LIMIT :limit")
    List<Exercise> findRandomExercises(@Param("limit") int limit);
}