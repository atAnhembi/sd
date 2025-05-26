package br.anhembi.springtest.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.anhembi.springtest.dtos.UserDto;
import br.anhembi.springtest.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/new")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

}
