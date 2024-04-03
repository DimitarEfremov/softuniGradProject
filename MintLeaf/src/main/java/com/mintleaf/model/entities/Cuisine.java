package com.mintleaf.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
@Entity
@Table(name = "cuisines")
public class Cuisine extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String cuisineName;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "cuisine"
    )
    private List<Recipe> recipeList;

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
