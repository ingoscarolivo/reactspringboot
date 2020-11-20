package com.example.user.controller.user;

import java.util.ArrayList;
import java.util.List;

import com.example.user.controller.UserController;
import com.example.user.dto.UserDTO;
import com.example.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTestGetUsers {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    @DisplayName("Should return a list with information of two users")
    void should_return_a_list_with_information_of_two_users ()  {
        List<UserDTO> listReturn;
        int sizeExpected = 2;
        List<UserDTO> listExpected = new ArrayList<>();

        UserDTO personA = new UserDTO(1L,"Person A","Person A last name","person-a@email.com");
        UserDTO personB = new UserDTO(2L,"Person B","Person B last name","person-b@email.com");

        listExpected.add(personA);
        listExpected.add(personB);

        when(service.getUsers()).thenReturn(listExpected);
        listReturn  = controller.findAll();

        assertNotNull(listReturn);
        assertEquals(listReturn.size(),sizeExpected);

    }
}