package com.epam.kubernetes_intensive.service;

import com.epam.kubernetes_intensive.dao.UserRepository;
import com.epam.kubernetes_intensive.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("User with id = {} doesn't exist", id)
        ));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUserById(Long id, boolean isPositive) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("User with id = {} doesn't exist", id)));

        int numberOfPosts = user.getNumberOfPosts();
        int updatedNumberOfPosts = isPositive ? numberOfPosts + 1 : numberOfPosts - 1;

        user.setNumberOfPosts(updatedNumberOfPosts);
        userRepository.save(user);
    }
}
