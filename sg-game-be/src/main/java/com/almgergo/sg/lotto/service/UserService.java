package com.almgergo.sg.lotto.service;

import com.almgergo.sg.lotto.model.User;
import com.almgergo.sg.lotto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> all() {
        return this.userRepository.findAll();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User signIn(String userId, String password) {
        User dbUser = this.userRepository.findById(userId).orElse(null);

        if (dbUser != null && dbUser.getPassword().equals(password)) {
            return dbUser;
        }

        return null;
    }
}
