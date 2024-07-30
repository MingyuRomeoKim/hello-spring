package hello.hello_spring.controllers;


import hello.hello_spring.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

    @PostMapping("/join")
    public ResponseEntity<User> join() {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login() {
        return null;
    }

    @PostMapping("/logout")
    public Boolean logout() {
        return false;
    }
}
