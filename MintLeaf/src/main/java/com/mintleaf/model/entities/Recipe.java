package com.mintleaf.model.entities;

import com.mintleaf.model.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String recipeName;

    @Enumerated(EnumType.STRING)
    private Type category;

    @ManyToOne
    private Cuisine cuisine;

    private String imageURL;

    private byte[] imageData;

    private String prepTime;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "recipe"
    )
    private List<Ingredient> ingredients;

    private String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "recipe"
    )
    private List<Direction> directions;


    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "recipe"
    )
    private List<Comment> comments;

    @ManyToOne
    private User createdBy;

    private boolean approvedByAdmin;


}
