package com.example.user.service;

import java.util.List;
import java.util.Optional;

import com.example.user.dto.UserDTO;
import com.example.user.model.User;
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

    public UserDTO save(UserDTO newUser) {
        User user = repository.save(UserDTO.mapToEntity(newUser));
        return UserDTO.mapToDTO(user);
    }

    public UserDTO singleUser(Long id) {
        Optional<User> user = repository.findById(id);
        return UserDTO.mapToDTO( user.get() );
    }


    public UserDTO updateUser(User updateUser, Long id) {
        repository.findById(id).map(user -> {
            user.setEmail(updateUser.getEmail());
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            return repository.save(user);
        });
        return  null;
    }

    public Long deleteUser(Long id) {
        repository.deleteById(id);
        return id;
    }

}
