package com.mintleaf.model.entities;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class Cuisine extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String cuisineName;

}
