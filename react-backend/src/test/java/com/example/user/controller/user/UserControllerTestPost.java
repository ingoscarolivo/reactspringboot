package com.example.user.controller.user;

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTestPost {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    @DisplayName("Should return a  new user with his id ")
    void should_return_a_new_user()  {
        UserDTO userDTOReturn;

        UserDTO personSent = new UserDTO(0L,"Person A","Person A last name","person-a@email.com");
        UserDTO personSave = new UserDTO(5L,"Person A","Person A last name","person-a@email.com");

        when(service.save(any(UserDTO.class))).thenReturn(personSave);

        userDTOReturn  = controller.insert(personSent);

        assertNotNull(userDTOReturn);
        assertEquals(userDTOReturn.getId(), personSave.getId());

    }
}
