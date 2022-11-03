package com.niit.jpa.jpaDemo.Controller;

import com.niit.jpa.jpaDemo.Domain.User;
import com.niit.jpa.jpaDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetail/v1")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUserDetail(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.FOUND);
    }
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUserByEmail(email),HttpStatus.OK);
    }
    @GetMapping("/user/{firstName}")
    public ResponseEntity<?> fetchByName(@PathVariable String firstName){
        return new ResponseEntity<>(userService.getUserByFirstName(firstName),HttpStatus.FOUND);
    }
    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateByEmail(@PathVariable User user, String email){
        return new ResponseEntity<>(userService.updateUser(user,email),HttpStatus.OK);
    }


}
