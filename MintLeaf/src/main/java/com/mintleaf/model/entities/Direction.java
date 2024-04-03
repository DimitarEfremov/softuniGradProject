package com.mintleaf.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "directions")
public class Direction extends BaseEntity {

    private String description;

    @ManyToOne
    private Recipe recipe;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe getRecipeList() {
        return recipe;
    }

    public void setRecipeList(Recipe recipeList) {
        this.recipe = recipeList;
    }
}
