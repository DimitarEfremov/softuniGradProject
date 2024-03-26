package com.mintleaf.model.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateUserDTO {

    @NotEmpty
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    String username;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    String password;
    @NotEmpty
    String passwordConfirm;
    @NotBlank(message = "Email cannot be empty!")
    @Email
    String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
