package com.niit.jpa.jpaDemo.Service;

import com.niit.jpa.jpaDemo.Domain.User;
import com.niit.jpa.jpaDemo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
     UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isEmpty()){
            return null;
        }
        User exitingUser =optionalUser.get();
        if (user.getFirstName()!=null){
            exitingUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName()!=null){
            exitingUser.setLastName(user.getLastName());
        }
        if (user.getPassword()!=null){
            exitingUser.setPassword(user.getPassword());
        }
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
         userRepository.deleteById(email);
         return true;
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
