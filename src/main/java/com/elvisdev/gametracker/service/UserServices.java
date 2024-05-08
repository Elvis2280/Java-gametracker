package com.elvisdev.gametracker.service;

import com.elvisdev.gametracker.dto.UserCreateDto;
import com.elvisdev.gametracker.dto.UserDto;
import com.elvisdev.gametracker.model.User;
import com.elvisdev.gametracker.repository.UserAccount;
import com.elvisdev.gametracker.util.CustomError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServices {
    private final UserAccount userAccount;
    private final ModelMapper mapper;

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

    public UserDto createUser(User user){
        User existingUser = userAccount.findByEmail(user.getEmail()).orElse(null);
        if(existingUser != null){
            log.info("User with email {} already exists", user.getEmail());
            throw new CustomError("User with email " + user.getEmail() + " already exists");
        }

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
        user.setActive(true);
        user.setVerified(false);
        User newUser = userAccount.save(user);
        UserDto newUserDto = mapper.map(newUser, UserDto.class);

        log.info("User with id {} created", newUser.getId());
        return newUserDto;
    }

    public User updateUser(User user){
        User existUser = userAccount.findById(user.getId().toString()).orElse(null);
        if(existUser == null){
            log.info("User with id {} not found", user.getId());
            return null;
        }

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

    public void verifyUser(String id){
        Optional<User> user = userAccount.findById(id);
        if(user.isPresent()){
            user.get().setVerified(true);
            userAccount.save(user.get());
            return;
        }
        log.info("User with id {} not found", id);
    }
}
