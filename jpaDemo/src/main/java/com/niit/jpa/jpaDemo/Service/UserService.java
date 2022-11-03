package com.niit.jpa.jpaDemo.Service;

import com.niit.jpa.jpaDemo.Domain.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public List<User> getAllUsers();
    public User updateUser(User user,String email);
    public boolean deleteUserByEmail(String email);
    public List<User>getUserByFirstName(String firstName);
}
