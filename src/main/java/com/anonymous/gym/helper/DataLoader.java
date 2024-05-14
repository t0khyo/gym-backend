package com.anonymous.gym.helper;

import com.anonymous.gym.model.entity.Exercise;
import com.anonymous.gym.model.entity.WorkoutPlan;
import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import com.anonymous.gym.repository.ExerciseRepository;
import com.anonymous.gym.repository.MealRepository;
import com.anonymous.gym.repository.WorkoutPlanRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DataLoader {
    private final ObjectMapper objectMapper;
    private final MealRepository mealRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final ExerciseRepository exerciseRepository;
    private List<Exercise> beginnersExercises;
    private List<Exercise> intermediateExercises;
    private List<Exercise> expertExercises;

    public void loadExercisesFromJsonFile() throws IOException {
        ClassPathResource beginnerFilePath = new ClassPathResource("beginnerExercises.json");
        ClassPathResource intermediateFilePath = new ClassPathResource("intermediateExercises.json");
        ClassPathResource expertFilePath = new ClassPathResource("expertExercises.json");
        this.beginnersExercises = objectMapper.readValue(beginnerFilePath.getInputStream(), new TypeReference<List<Exercise>>() {
        });
        this.intermediateExercises = objectMapper.readValue(intermediateFilePath.getInputStream(), new TypeReference<List<Exercise>>() {
        });
        this.expertExercises = objectMapper.readValue(expertFilePath.getInputStream(), new TypeReference<List<Exercise>>() {
        });

    }

    @PostConstruct
    private void initDb() throws IOException {

        loadExercisesFromJsonFile();
        expertExercises.forEach(System.out::println);
        loadWorkoutPlans();
    }


    private void loadWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = List.of(
                WorkoutPlan.builder()
                        .difficulty(ExerciseDifficulty.beginner)
                        .description("This is a beginner workout plan!")
                        .exercises(this.beginnersExercises)
                        .build(),
                WorkoutPlan.builder()
                        .difficulty(ExerciseDifficulty.intermediate)
                        .description("This is an intermediate workout plan!")
                        .exercises(intermediateExercises)
                        .build(),
                WorkoutPlan.builder()
                        .difficulty(ExerciseDifficulty.expert)
                        .description("This is an expert workout plan!")
                        .exercises(expertExercises)
                        .build()
        );

        workoutPlanRepository.saveAll(workoutPlans);
    }


}
