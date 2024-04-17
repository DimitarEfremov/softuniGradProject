package com.mintleaf.service;

import com.mintleaf.model.DTOs.CreateUserDTO;
import com.mintleaf.model.entities.User;

public interface UserService {
    boolean registerUser(CreateUserDTO createUserDTO);

    User getUserByName(String currentUserName);
}
