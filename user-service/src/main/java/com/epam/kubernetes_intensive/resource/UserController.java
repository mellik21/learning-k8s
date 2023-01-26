package com.epam.kubernetes_intensive.resource;

import com.epam.kubernetes_intensive.model.User;
import com.epam.kubernetes_intensive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserAPI {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }

    @Override
    public void updateUserById(Long id, boolean isPositive) {
        userService.updateUserById(id, isPositive);
    }

    @Override
    public void createUser(User user) {
         userService.createUser(user);
    }
}
