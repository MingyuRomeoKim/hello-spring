package hello.hello_spring.controllers;

import hello.hello_spring.models.Users;
import hello.hello_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> list() {
        List<Users> users = userService.findUsers();
        return users;
    }

    @PostMapping("/user")
    public Long create(Users users) {
        Long userId = userService.join(users);
        return userId;
    }

}
