package com.elvisdev.gametracker.repository;

import com.elvisdev.gametracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccount extends JpaRepository<User, String>{
}
