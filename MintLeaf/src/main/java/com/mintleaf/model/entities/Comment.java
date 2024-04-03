package com.mintleaf.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    @OneToOne
    private User addedBy;

    private String content;

    @ManyToOne
    private Recipe recipe;

}
