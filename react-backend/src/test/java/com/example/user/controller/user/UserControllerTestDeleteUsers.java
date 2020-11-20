package com.example.user.controller.user;

import com.example.user.controller.UserController;
import com.example.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTestDeleteUsers {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    @DisplayName("Should return delete users")
    void should_return_delete_users() {

        Long userIdReturn;

        Long deletePerson = 1L;

        when(service.deleteUser(any(Long.class))).thenReturn(deletePerson);

        userIdReturn = controller.delete(deletePerson);

        assertNotNull(userIdReturn);
        assertEquals(userIdReturn, deletePerson);

    }

}
