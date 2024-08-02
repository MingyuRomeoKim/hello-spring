package hello.hello_spring.services;

import hello.hello_spring.models.Users;
import hello.hello_spring.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    protected final String testMail = "test@mail.com";

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void join() {
        Users user = new Users();
        user.setName("mingyu");
        user.setPassword("123456");
        user.setEmail(this.testMail);
        userService.join(user);

        Users findUser = userService.findUserByEmail(user.getEmail()).get();
        assertThat(findUser.getName()).isEqualTo(user.getName());
    }
}
