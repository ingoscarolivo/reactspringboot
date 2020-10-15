package com.example.user.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.user.model.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 4835606708278639517L;

    private long id;
    private String firstName;
    private String lastName;
    private String email;


    public UserDTO(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id &&
                Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(email, userDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    public static List<UserDTO> mapToDTO(List<User> list) {
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

}
