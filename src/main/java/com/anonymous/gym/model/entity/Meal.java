package com.anonymous.gym.model.entity;

import com.anonymous.gym.model.entity.enums.MealType;
import jakarta.persistence.Embedded;
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
public class Meal extends BaseEntity {
    private String name;

    @Enumerated(value=EnumType.STRING)
    private MealType type;

    private String description;

    private int calories;

    @Embedded
    private Nutrients nutrients;

}
