package com.example.user.controller.user;

import com.example.user.controller.UserController;
import com.example.user.dto.UserDTO;
import com.example.user.model.User;
import com.example.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTestPutUsers {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    @DisplayName("Should return a updated users")
    void should_return_update_user()  {
        UserDTO userDTOReturn;

        UserDTO personUpdate = new UserDTO(5L,"Person A","Person A last name","person-a@email.com");
        User personUser = new User(6L,"Person B","Person B last name","personb-a@email.com");
        User userMokito = Mockito.mock(User.class);

        when(service.updateUser(personUser,6L)).thenReturn(personUpdate);

        userDTOReturn  = controller.update(personUser,6L);

        assertNotNull(userDTOReturn);
        assertEquals(userDTOReturn.getId(), personUpdate.getId());
        assertEquals(userDTOReturn.getFirstName(), "Person A");

    }
}
