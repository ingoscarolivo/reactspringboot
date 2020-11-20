package com.example.user.controller;

import java.util.List;

import com.example.user.dto.UserDTO;
import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    UserService service;

    @Autowired
    public void setService(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return service.getUsers();
    }

    @PostMapping
    public UserDTO insert(@RequestBody UserDTO newUser) {
        return service.save(newUser);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return service.singleUser(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@RequestBody User updateUser, @PathVariable Long id){
        return service.updateUser(updateUser,id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return service.deleteUser(id);
    }

}
