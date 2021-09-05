package com.example.personalExpenseManager.Controller;

import com.example.personalExpenseManager.Entity.Users;
import com.example.personalExpenseManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    UserService userService;

    @PostMapping("")
    private Users submitUser(@RequestBody Users users) {
        return userService.submitMetaDataOfUser(users);
    }

    @GetMapping("/{userid}")
    private Users getUserDetails(@PathVariable("userid") String userId) {
        return userService.displayUserMetaData(userId);
    }
}