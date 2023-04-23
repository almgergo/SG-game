package com.almgergo.sg.lotto.initializer;

import com.almgergo.sg.lotto.model.User;
import com.almgergo.sg.lotto.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {
    private final UserService userService;

    public DbInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeUsers();
    }

    private void initializeUsers() {
        userService.save(new User("password", "john@john.com", "password"));
        userService.save(new User("2", "peter123", "2"));
        userService.save(new User("3", "maunika", "3"));
        userService.save(new User("c00l", "admin", "c00l"));
    }
}
