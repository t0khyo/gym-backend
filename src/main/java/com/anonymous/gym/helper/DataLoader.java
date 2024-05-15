package com.anonymous.gym.helper;

import com.anonymous.gym.model.entity.*;
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

        List<Meal> healthy_weight = List.of(
                Meal.builder()
                        .name("Eggs Crème Fraîche")
                        .description("Easy breakfasts don’t have to be boring. With some simple techniques (low and slow makes for the fluffiest eggs!) and a little smoked trout, this scramble makes my a.m. extra elegant! — Associate Food Editor Becca Miller")
                        .type(MealType.BREAKFAST)
                        .calories(400)
                        .nutrients(new Nutrients(30, 34, 7))
                        .build(),
                Meal.builder()
                        .name("Peanut Chicken Protein Bowls")
                        .description("Preheat oven to 425°. On a large baking sheet, toss potatoes and onion with 1 tablespoon olive oil; season with salt and pepper. Bake until tender, 20 to 25 minutes")
                        .type(MealType.LUNCH)
                        .calories(550)
                        .nutrients(new Nutrients(50, 24, 10))
                        .build(),
                Meal.builder()
                        .name("Pinwheel Sandwiches")
                        .description("On a clean surface, lay tortillas flat. Spread each tortilla with 1 tablespoon mayonnaise mixture. Place 2 to 3 slices cheese on bottom two-thirds of each tortilla. Top cheese with ham and turkey. Top meat with 2 to 3 lettuce leaves and tightly roll up.")
                        .calories(600)
                        .type(MealType.DINNER)
                        .nutrients(new Nutrients(23, 50, 12))
                        .build()
        );

        List<Meal> underweight = List.of(
                Meal.builder()
                        .name("Lemony Chickpea Quinoa Salad")
                        .description("This protein-packed salad is full of fresh, bright flavors and perfect for a quick lunch or light dinner. Cannellini beans can be substituted for the chickpeas if desired.")
                        .type(MealType.LUNCH)
                        .calories(420)
                        .nutrients(new Nutrients(18, 32, 15))
                        .build(),
                Meal.builder()
                        .name("Salmon with Roasted Asparagus")
                        .description("Simple yet impressive, this dish is perfect for a weeknight meal. The asparagus roasts alongside the salmon, minimizing cleanup. Serve with a side of brown rice or quinoa for a complete meal.")
                        .type(MealType.DINNER)
                        .calories(500)
                        .nutrients(new Nutrients(40, 30, 8))
                        .build(),
                Meal.builder()
                        .name("Spiced Black Bean Burgers")
                        .description("These vegetarian burgers are packed with flavor and protein. Serve them on whole-wheat buns with your favorite toppings, like avocado, salsa, and lettuce.")
                        .type(MealType.DINNER)
                        .calories(650)
                        .nutrients(new Nutrients(25, 45, 20))
                        .build()
        );

        List<Meal> bulkingMeals = List.of(
                Meal.builder()
                        .name("Turkey Chili with Brown Rice")
                        .description("This hearty chili is packed with lean protein from ground turkey, kidney beans, and black beans. Brown rice adds complex carbs for sustained energy.")
                        .type(MealType.DINNER)
                        .calories(700)
                        .nutrients(new Nutrients(55, 60, 20))
                        .build(),
                Meal.builder()
                        .name("Greek Yogurt Parfait with Berries and Granola")
                        .description("A delicious and nutritious way to start your day. Greek yogurt provides protein and calcium, while berries and granola add carbs and healthy fats.")
                        .type(MealType.BREAKFAST)
                        .calories(500)
                        .nutrients(new Nutrients(40, 40, 15))
                        .build(),
                Meal.builder()
                        .name("Chicken Stir-Fry with Brown Rice and Vegetables")
                        .description("A stir-fry is a quick and easy way to get a complete meal. Chicken breast provides protein, while brown rice offers complex carbs. Don't forget to load up on colorful vegetables!")
                        .type(MealType.LUNCH)
                        .calories(620)
                        .nutrients(new Nutrients(60, 45, 18))
                        .build()
        );

        DietPlan healthyPlan = DietPlan.builder()
                .meals(healthy_weight)
                .description("healthy diet plan")
                .type(DietPlanType.healthy_weight)
                .dailyCalories(1700)
                .build();

        DietPlan underweightPlan = DietPlan.builder()
                .meals(underweight)
                .description("underweight diet plan")
                .type(DietPlanType.overweight)
                .dailyCalories(2000)
                .build();

        DietPlan bulkingPlan = DietPlan.builder()
                .meals(healthy_weight)
                .description("healthy diet plan")
                .type(DietPlanType.underweight)
                .dailyCalories(2500)
                .build();



    }
}
