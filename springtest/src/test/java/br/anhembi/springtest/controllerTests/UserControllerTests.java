package br.anhembi.springtest.controllerTests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.anhembi.springtest.controllers.UserController;
import br.anhembi.springtest.dtos.UserDto;
import br.anhembi.springtest.services.UserService;


@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    public void registerUserSuccess() throws Exception {
        // Prepare a valid UserDto request body
        String userDtoJson = "{\"name\": \"Test\", \"email\": \"test@gmail.com\"}";

        // Mock userService.registerUser to return a successful response
        when(userService.registerUser(any())).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("Success: User details successfully saved!"));

        // Perform POST request to /user/new with valid UserDto
        mockMvc.perform(MockMvcRequestBuilders.post("/user/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("Success: User details successfully saved!"));
    }

    @Test
    public void registerUserWithAlreadyExistsEmailFail() throws Exception {
        // Prepare a valid UserDto request body
        String userDtoJson = "{\"name\": \"Test\", \"email\": \"test@gmail.com\"}";

        // Mock userService.registerUser to return a conflict response
        when(userService.registerUser(any())).thenReturn(ResponseEntity.status(HttpStatus.CONFLICT).body("Fail: Email already exists!"));

        // Perform POST request to /user/new with valid UserDto
        mockMvc.perform(MockMvcRequestBuilders.post("/user/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJson))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andExpect(MockMvcResultMatchers.content().string("Fail: Email already exists!"));
    }

    @Test
    public void registerUserWithInternalServerErrorFail() throws Exception {
        // Prepare a valid UserDto request body
        String userDtoJson = "{\"name\": \"Test\", \"email\": \"test@gmail.com\"}";

        // Mock userService.registerUser to return a exception response
        when(userService.registerUser(any())).thenReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail: Failed to process request now. Try again later"));

        // Perform POST request to /user/new with valid UserDto
        mockMvc.perform(MockMvcRequestBuilders.post("/user/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJson))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().string("Fail: Failed to process request now. Try again later"));
    }

    @Test
    public void registerUserWithInvalidUserDtoValuesFail() throws Exception {
        // Prepare an invalid UserDto request body with an no name and invalid email
        String userDtoJson = "{\"email\": \"testgmail.com\"}";

        // Perform a POST request to /user/new with the invalid UserDto
        mockMvc.perform(MockMvcRequestBuilders.post("/user/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJson))
                // Verify that the response status code is 400 Bad Request
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Name is required!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("Email is not in valid format!"));

        // Verify that the UserService's registerUser method is not called
        verify(userService, times(0)).registerUser(any(UserDto.class));
    }



}
