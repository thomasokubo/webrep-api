package com.repnation.webrep.controller;

import com.repnation.webrep.domain.model.User;
import com.repnation.webrep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
