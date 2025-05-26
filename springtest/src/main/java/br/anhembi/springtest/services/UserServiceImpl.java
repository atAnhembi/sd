package br.anhembi.springtest.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.anhembi.springtest.dtos.UserDto;
import br.anhembi.springtest.models.User;
import br.anhembi.springtest.repositories.UserRepository;

@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Object> registerUser(UserDto userDto){

        try {
            if (userRepository.findByEmail(userDto.getEmail()) == null) {
                User newUser = User.builder().name(userDto.getName()).email(userDto.getEmail()).build();

                userRepository.save(newUser);

                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Success: User details successfully saved!");
            }

        } catch (Exception e) {
            log.error("User registration fail: " + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fail: Failed to process request now. Try again later");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Fail: Email already exists!");

    }

}
