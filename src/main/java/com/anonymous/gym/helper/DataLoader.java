package com.anonymous.gym.helper;

import com.anonymous.gym.model.entity.Exercise;
import com.anonymous.gym.model.entity.Meal;
import com.anonymous.gym.model.entity.Nutrients;
import com.anonymous.gym.model.entity.WorkoutPlan;
import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import com.anonymous.gym.model.entity.enums.MealType;
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

    private void loadMeals() {
        List<Meal> meals = List.of(
                Meal.builder()
                        .name("Tomato and Feta Baked Eggs")
                        .description("Smoky roasted tomatoes, salty feta, and sunny eggs all bake together on a single sheet pan! Spoon it on top of toast for a crowd-pleasing (and hassle-free) brunch.")
                        .type(MealType.BREAKFAST)
                        .calories(300)
                        .nutrients(new Nutrients(25, 40, 5))
                        .build(),
                Meal.builder()
                        .name("Peanut Chicken Protein Bowls")
                        .description("Preheat oven to 425°. On a large baking sheet, toss potatoes and onion with 1 tablespoon olive oil; season with salt and pepper. Bake until tender, 20 to 25 minutes")
                        .type(MealType.LUNCH)
                        .calories(550)
                        .nutrients(new Nutrients(50,24,10))
                        .build()
        );

        List<Meal> meals1 = List.of(
                Meal.builder()
                        .name("Scrambled Eggs with Smoked Trout and Crème Fraîche")
                        .description("Easy breakfasts don’t have to be boring. With some simple techniques (low and slow makes for the fluffiest eggs!) and a little smoked trout, this scramble makes my a.m. extra elegant! — Associate Food Editor Becca Miller")
                        .type(MealType.BREAKFAST)
                        .calories(400)
                        .nutrients(new Nutrients(30,34,7))
                        .build()
        );
    }
}
