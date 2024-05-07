package com.elvisdev.gametracker.controller;

import com.elvisdev.gametracker.dto.UserCreateDto;
import com.elvisdev.gametracker.dto.UserDto;
import com.elvisdev.gametracker.model.User;
import com.elvisdev.gametracker.service.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto userCreateDto){
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        User newUser = userServices.createUser(user);

        if(newUser == null){
            return ResponseEntity.badRequest().build();
        }

        UserDto newUserDto = new UserDto();
        newUserDto.setUsername(newUser.getUsername());
        newUserDto.setEmail(newUser.getEmail());
        newUserDto.setActive(newUser.isActive());
        newUserDto.setVerified(newUser.isVerified());

        return ResponseEntity.ok(newUserDto);
    }

}
