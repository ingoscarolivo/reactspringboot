package com.example.user.controller;

import java.util.List;

import com.example.user.dto.UserDTO;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {
    UserService service;

    @Autowired
    public void setService(UserService service){
        this.service = service;
    }

    @GetMapping("users")
        public List<UserDTO> getUsers() {
            return service.getUsers();
        }

}
