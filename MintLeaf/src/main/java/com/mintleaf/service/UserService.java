package com.mintleaf.service;

import com.mintleaf.model.DTOs.CreateUserDTO;

public interface UserService {
    boolean registerUser(CreateUserDTO createUserDTO);
}
