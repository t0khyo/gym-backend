package com.anonymous.gym.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(callSuper=true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DietPlan extends BaseEntity {
    private String description;

    private int dailyCalories;

    private DietPlanType type;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Meal> meals;
}
