package com.fil.easemystay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fil.easemystay.entities.User;
import com.fil.easemystay.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        return this.userservice.createUser(user);
    }
    

    @PostMapping("/login")
    public User loginUser(@RequestBody User loginRequest) {
        String username = loginRequest.getUser_name();
        String password = loginRequest.getUser_password();

        User authenticatedUser = this.userservice.loginUser(username, password);

        if (authenticatedUser != null) {
            return authenticatedUser;
        } else {
            return null;
        }
       }
    
    @PutMapping("/easemystay/update")
    public User updateUser(@RequestBody User user) {
        return this.userservice.updateUser(user);
    }
    
    @DeleteMapping("/easemystay/delete")
    public String deleteUser(@RequestBody User user) {
        User userNew = new User();
        userNew.setUser_email(user.getUser_email());
        
        if (this.userservice.deleteUser(user)) {
            return "User with email  has been deleted.";
        } else {
            return "User with email not found or could not be deleted.";
        }
    }
    
    
    
}
