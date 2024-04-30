package com.elvisdev.gametracker.service;

import com.elvisdev.gametracker.model.User;
import com.elvisdev.gametracker.repository.UserAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServices {
    private final UserAccount userAccount;

    public User getUserById(String id){
        Optional<User> user = userAccount.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        log.info("User with id {} not found", id);
        return null;
    }

    public List<User> getAllUsers(){
        return userAccount.findAll();
    }

    public User createUser(User user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
        user.setActive(true);
        User newUser = userAccount.save(user);
        log.info("User with id {} created", newUser.getId());
        return newUser;
    }

    public User updateUser(User user){
        user.setUpdateAt(LocalDateTime.now());
        User updatedUser = userAccount.save(user);
        log.info("User with id {} updated", updatedUser.getId());
        return updatedUser;
    }

    public void disableUser(String id){
        Optional<User> user = userAccount.findById(id);
        if(user.isPresent()){
            user.get().setActive(false);
            userAccount.save(user.get());
            log.info("User with id {} disabled", id);
        }
        log.info("User with id {} not found", id);
    }

    public void deleteUser(String id){
        Optional<User> user = userAccount.findById(id);
        if(user.isPresent()){
            userAccount.delete(user.get());
            log.info("User with id {} deleted", id);
        }
        log.info("User with id {} not found", id);
    }
}
