package com.anonymous.gym.model.entity;

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

    private String description;

    private int reps;

    private String gifUrl;

}
