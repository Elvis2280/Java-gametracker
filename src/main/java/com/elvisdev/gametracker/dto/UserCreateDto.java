package com.elvisdev.gametracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateDto {
    @NotNull
    @Size(min = 3, max = 40)
    private String username;
    @Email
    @NotNull
    @Size(min = 3, max = 50)
    private String email;
    @NotNull
    @Size(min = 8, max = 50)
    private String password;
}
