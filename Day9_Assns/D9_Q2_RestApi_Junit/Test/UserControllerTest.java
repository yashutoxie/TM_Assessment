package com.test.UserManagement;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class UserControllerTest {

    @Mock
    private UserService userService; // Mock the service

    @InjectMocks
    private UserController userController; // Inject the mock into controller

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testCreateUser() {
        // Arrange
        User mockUser = new User(1, "Alice", "alice@example.com");
        when(userService.createUser(any(User.class))).thenReturn(mockUser);

        // Act
        ResponseEntity<User> response = userController.createUser(mockUser);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("Alice", response.getBody().getName());
        verify(userService, times(1)).createUser(any(User.class));
    }
}
