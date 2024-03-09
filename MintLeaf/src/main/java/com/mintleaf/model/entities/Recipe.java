package com.mintleaf.model.entities;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Recipe extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String recipeName;

    private Type foodType;

    private Cuisine cuisine;

    private String imagePath;

    private String description;

    private List<Ingredient> ingredients;

    private List<Direction> directions;

    private List<Comment> comments;



}
