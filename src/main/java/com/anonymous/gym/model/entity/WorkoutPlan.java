package com.anonymous.gym.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString(callSuper=true)
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlan extends BaseEntity {
    @OneToOne
    private User user;

    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Exercise> exercises;
}
