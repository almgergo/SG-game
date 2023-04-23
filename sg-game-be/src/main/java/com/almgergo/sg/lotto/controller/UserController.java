package com.almgergo.sg.lotto.controller;

import com.almgergo.sg.lotto.dto.UserDto;
import com.almgergo.sg.lotto.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> all() {
        return userService.all().stream().map(user -> new UserDto(user.getId(), user.getUsername())).collect(Collectors.toList());
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<UserDto> signIn(@PathVariable String userId, @RequestBody SignInRequest request) {
        var user = userService.signIn(userId, request.getPassword());
        if (user == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        else return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername()));
    }

}

@Data
class SignInRequest {
    private String password;
}