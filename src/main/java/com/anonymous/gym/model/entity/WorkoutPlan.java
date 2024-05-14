package com.anonymous.gym.model.entity;

import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@ToString(callSuper=true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlan{
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    private String description;

    @Enumerated(EnumType.STRING)
    private ExerciseDifficulty difficulty;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Exercise> exercises;
}
