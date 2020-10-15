package com.example.user.service;

import java.util.List;

import com.example.user.dto.UserDTO;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    public List<UserDTO> getUsers() {
        return UserDTO.mapToDTO( repository.findAll());
    }



}
