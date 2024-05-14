package com.anonymous.gym.model.entity;

import com.anonymous.gym.model.entity.enums.ExerciseType;
import com.anonymous.gym.model.entity.enums.Muscle;
import jakarta.persistence.Entity;
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

    private String equipment;

    private Muscle muscle;

    private String instructions;

    private String gifUrl;

}
