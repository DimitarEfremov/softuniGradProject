package com.mintleaf.service.Impl;

import com.mintleaf.model.entities.User;
import com.mintleaf.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MintUserDetailService implements UserDetailsService {

    private final UserRepository userRepository ;

    public MintUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findAllByUserName(username)
                .map(MintUserDetailService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!") );

    }

    private static UserDetails map(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .authorities(String.valueOf(user.getUserRight())).build();

    }
}
