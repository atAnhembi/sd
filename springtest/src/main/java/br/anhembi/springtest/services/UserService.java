package br.anhembi.springtest.services;


import org.springframework.http.ResponseEntity;

import br.anhembi.springtest.dtos.UserDto;

public interface UserService {
    ResponseEntity<Object> registerUser(UserDto userDto);

}
