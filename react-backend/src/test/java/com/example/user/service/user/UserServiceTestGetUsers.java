package com.example.user.service.user;

import java.util.ArrayList;
import java.util.List;

import com.example.user.dto.UserDTO;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
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
class UserServiceTestGetUsers {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    @DisplayName("Should return a list with information of two users")
    void should_return_a_list_with_information_of_two_users () {
    List<UserDTO> listReturn;
        int sizeExpected = 2;
        List<User> listExpected = new ArrayList<>();

        User personA = new User(1L,"Person A","Person A last name","person-a@email.com");
        User personB = new User(2L,"Person B","Person B last name","person-b@email.com");

        listExpected.add(personA);
        listExpected.add(personB);

        when(repository.findAll()).thenReturn(listExpected);

        List<UserDTO>  userListDTO =  service.getUsers();

       assertNotNull(userListDTO);
       assertEquals(userListDTO.size(),sizeExpected);

    }
}