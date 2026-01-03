package com.crdpls.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crdpls.api.models.User;
import com.crdpls.api.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*") // allow Angular to access API
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public User login(@RequestBody User loginData) {
        User user = userRepo.findByEmail(loginData.getEmail());

        if (user != null && user.getPassword().equals(loginData.getPassword())) {
            return user; // return user object with name for Angular
        }

        return null; // login failed
    }
}
