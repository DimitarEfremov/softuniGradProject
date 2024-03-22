package com.mintleaf.service.Impl;

import com.mintleaf.model.DTOs.CreateUserDTO;
import com.mintleaf.model.entities.User;
import com.mintleaf.repo.UserRepository;
import com.mintleaf.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean registerUser(CreateUserDTO createUserDTO) {

        User user = new User();
        user.setUserName(createUserDTO.getUsername());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setUserRight();

        userRepository.save(user);
        return true;
    }
}
