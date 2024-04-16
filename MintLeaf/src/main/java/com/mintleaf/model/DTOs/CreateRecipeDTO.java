package com.mintleaf.model.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class CreateRecipeDTO {


    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String recipeName;

    private byte[] imageData;

    private String imageURL;


    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
