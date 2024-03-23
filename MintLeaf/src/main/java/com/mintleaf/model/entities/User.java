package com.mintleaf.model.entities;

import com.mintleaf.model.enums.Rights;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String userName;

    @Column(nullable = false)
    @Size(min = 2, max = 18)
    private String password;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Rights userRight;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rights getUserRight() {
        return userRight;
    }

    public void setUserRight() {
        this.userRight = Rights.USER;
    }
}
