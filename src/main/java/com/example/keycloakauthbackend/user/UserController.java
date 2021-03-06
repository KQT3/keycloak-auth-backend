package com.example.keycloakauthbackend.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping("create-account")
    public ResponseEntity<UserDTO> createAccount(@RequestParam String username, @RequestParam String password) {
        UserEntity userEntity = userService.createAccount(username, password);
        return ResponseEntity.ok(userDTO(userEntity));
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout() {
        return "logout";
    }


    public UserDTO userDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
    }
}
