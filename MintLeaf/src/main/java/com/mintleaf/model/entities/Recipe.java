package com.mintleaf.model.entities;

import com.mintleaf.model.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Recipe extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String recipeName;

    private Type category;

    private Cuisine cuisine;

    private String imagePath;

    private String prepTime;

    private List<Ingredient> ingredients;

    private String description;

    private List<Direction> directions;

    private List<Comment> comments;

    @ManyToOne
    private List<User> createdBy;

    @ManyToMany
    private List<User> likedBy;



}
