package com.mintleaf.repo;

import com.mintleaf.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllByUserName(String username);

    boolean existsByUserNameOrEmail(String username, String email);

    User findUserByUserName(String username);
}
