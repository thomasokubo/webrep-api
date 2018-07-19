package com.repnation.webrep.controller;

import com.repnation.webrep.domain.model.User;
import com.repnation.webrep.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
@Api(value = "usergroup", description = "Possible operations over the registered users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "View a list of users registered in the database", responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of users"),
            @ApiResponse(code = 401, message = "You're not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the requested resource is forbidden"),
            @ApiResponse(code = 404, message = "The requested resource is not found")
    })
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "View the user with the desired id", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of users"),
            @ApiResponse(code = 401, message = "You're not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the requested resource is forbidden"),
            @ApiResponse(code = 404, message = "The requested resource is not found")
    })
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }

    @ApiOperation(value = "Add a new user in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of users"),
            @ApiResponse(code = 401, message = "You're not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the requested resource is forbidden"),
            @ApiResponse(code = 404, message = "The requested resource is not found")
    })
    @PostMapping
    public void addNewUser(@RequestBody @NotNull User user) {
        userService.save(user);
    }
}
