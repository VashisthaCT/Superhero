package com.clearTax.training_superheros.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "superheroes") // MongoDB collection name
public class Superhero {

    @Id
    private String name; // Unique identifier

    private String power;
    private String gender;
    private String universe;
    private Integer age;
    private String archEnemy;

}