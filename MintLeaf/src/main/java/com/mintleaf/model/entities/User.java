package com.mintleaf.model.entities;

import com.mintleaf.model.enums.Rights;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

public class User extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String userName;

    @Column(nullable = false)
    @Size(min = 2, max = 18)
    private String password;

    @Email
    private String email;

    private Rights userRight;

    @OneToMany
    private List<Recipe> recipesAdded;

    @ManyToMany
    private List<Recipe> recipesLiked;


}
