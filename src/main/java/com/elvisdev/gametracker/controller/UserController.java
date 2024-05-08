package com.elvisdev.gametracker.controller;

import com.elvisdev.gametracker.dto.UserCreateDto;
import com.elvisdev.gametracker.dto.UserDto;
import com.elvisdev.gametracker.model.User;
import com.elvisdev.gametracker.service.UserServices;
import com.elvisdev.gametracker.util.CustomError;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServices userServices;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
        this.mapper = new ModelMapper();
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto userCreateDto){
            User userData = mapper.map(userCreateDto, User.class);
            UserDto newUser = userServices.createUser(userData);

            if(newUser == null){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().body(newUser);
    }
}
