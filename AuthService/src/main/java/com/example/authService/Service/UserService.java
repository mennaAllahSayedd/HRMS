package com.example.authService.Service;

import com.example.authService.Entities.User;
import com.example.authService.Exception.UserNotFoundException;
import com.example.authService.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repo;

    public boolean login(String username, String password) {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Invalid username"));

        return user.getPassword().equals(password);
    }

    public boolean register(String username, String password) {
        Optional<User> user = repo.findByUsername(username);
        if (!user.isPresent()) {
            User newUser = registerNewUser(username, password);
            log.info("User logged in successfully ");
            return true;
        } else {
            log.warn("User already registered, try to login");
            return false;
        }

    }

    private User registerNewUser(String username, String password) {
        int userNumber = generateUserNumber();
        User user = new User( userNumber,username, password,false);
        repo.save(user);
        return user;
    }

    private int generateUserNumber() {
        return (int)(Math.random() * 90000000) + 10000000;
    }

    private boolean activateUser(String username) {
        try {
            Optional<User> user = repo.findByUsername(username);
            if (user.isPresent()) {
                user.get().setEnabled(true);
                return true;
            } else {
                log.info("User Not Found");
                return false;
            }
        } catch (Exception e) {
            log.error("Exception while activating user {} ", username, e);
            return false;
        }
    }
}
