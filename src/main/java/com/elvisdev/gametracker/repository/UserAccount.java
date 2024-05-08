package com.elvisdev.gametracker.repository;

import com.elvisdev.gametracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccount extends JpaRepository<User, String>{
    Optional<User> findByEmail(String email);
}
