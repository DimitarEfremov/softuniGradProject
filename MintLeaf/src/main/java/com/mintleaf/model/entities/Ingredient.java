package com.mintleaf.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity{

    private String ingredientDescription;

    @ManyToOne
    private Recipe recipe;

    public String getIngredientDescription() {
        return ingredientDescription;
    }

    public void setIngredientDescription(String ingredientDescription) {
        this.ingredientDescription = ingredientDescription;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
