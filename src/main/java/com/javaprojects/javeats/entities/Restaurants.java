package com.javaprojects.javeats.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer restaurant_id;
    private String name;
    private String description;
    private String location;
}
