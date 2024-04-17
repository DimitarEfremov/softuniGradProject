package com.mintleaf.service.Impl;

import com.mintleaf.model.DTOs.CreateUserDTO;
import com.mintleaf.model.entities.User;
import com.mintleaf.repo.UserRepository;
import com.mintleaf.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(CreateUserDTO createUserDTO) {

        if (!createUserDTO.getPassword().equals(createUserDTO.getPasswordConfirm())){
            return false;
        }

        boolean existsByUsernameOrEmail = userRepository.existsByUserNameOrEmail(
                createUserDTO.getUsername(),
                createUserDTO.getEmail());

        if (existsByUsernameOrEmail) {
            return false;
        }


        User user = new User();
        user.setUserName(createUserDTO.getUsername());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setUserRight();

        userRepository.save(user);
        return true;
    }

    @Override
    public User getUserByName(String currentUserName) {

        return userRepository.findUserByUserName(currentUserName);

    }
}
