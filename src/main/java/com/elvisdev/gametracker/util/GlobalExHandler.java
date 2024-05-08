package com.elvisdev.gametracker.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExHandler {
    @ExceptionHandler(CustomError.class)
    public String handleCustomError(CustomError e){
        return e.getMessage();
    }
}
