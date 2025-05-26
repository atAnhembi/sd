package br.anhembi.springtest.repositoryTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.anhembi.springtest.models.User;
import br.anhembi.springtest.repositories.UserRepository;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveUser() {
        // Define test data
        String name = "test1";
        String email = "test1@example.com";

        // Create a User object with the test data
        User user = User.builder()
                .name(name)
                .email(email)
                .build();

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Assert that the retrieved user is not null
        assertNotNull(savedUser);

        // Assert that the retrieved user id is not null
        assertNotNull(savedUser.getId());

        // Assert that the retrieved user's name matches the expected name
        assertEquals(name, savedUser.getName());

        // Assert that the retrieved user's email matches the expected email
        assertEquals(email, savedUser.getEmail());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByEmailUserFound() {
        // Define test data
        String name = "test2";
        String email = "test2@gmail.com";

        // Create a User object with the test data
        User user = User.builder()
                .name(name)
                .email(email)
                .build();

        // Save the user to the database
        userRepository.save(user);

        // Retrieve the user from the database using findByEmail
        User foundUser = userRepository.findByEmail(email);

        // Assert that the retrieved user is not null
        assertNotNull(foundUser);

        // Assert that the retrieved user's email matches the expected email
        assertEquals(email, foundUser.getEmail());

        // Assert that the retrieved user's name matches the expected name
        assertEquals(name, foundUser.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByEmailUserNotFound() {
        // Find an non existent user
        User foundUser = userRepository.findByEmail("non.existent@example.com");

        // Assert that the retrieved user is null
        assertNull(foundUser);
    }

}
