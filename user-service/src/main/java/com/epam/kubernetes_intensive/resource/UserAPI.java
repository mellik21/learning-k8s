package com.epam.kubernetes_intensive.resource;

import com.epam.kubernetes_intensive.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserAPI {

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by ID")
    User getUserById(@PathVariable Long id);

    @GetMapping("/")
    @ApiOperation(value = "Get all users")
    List<User> getAllUsers();

    @PutMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Update user by ID")
    void updateUserById(@PathVariable Long id, @RequestParam("isPositive") boolean isPositive);

    @PostMapping("/")
    @ApiOperation(value = "Create user")
    void createUser(@RequestBody User user);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete user by ID")
    void deleteUserById(@PathVariable Long id);

}
