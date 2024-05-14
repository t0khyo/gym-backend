package com.anonymous.gym.model.entity;

import com.anonymous.gym.model.entity.enums.ExerciseDifficulty;
import com.anonymous.gym.model.entity.enums.ExerciseType;
import com.anonymous.gym.model.entity.enums.Muscle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@ToString(callSuper=true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exercise extends BaseEntity {
    private String name;

    private ExerciseType type;

    @Enumerated(EnumType.STRING)
    private Muscle muscle;

    private String equipment;

    @Enumerated(EnumType.STRING)
    private ExerciseDifficulty difficulty;

    @Column(length = 3000)
    private String instructions;


}
