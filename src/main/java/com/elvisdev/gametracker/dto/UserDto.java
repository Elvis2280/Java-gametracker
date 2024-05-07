package com.elvisdev.gametracker.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @NotNull
    @Size(min = 3, max = 40)
    private String username;
    @NotNull
    @Email
    @Size(min = 3, max = 50)
    private String email;
    @NotNull
    private boolean isVerified;
    @NotNull
    private boolean active;
}
