package hello.hello_spring.repositories;

import hello.hello_spring.models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    protected final String testMail = "test@mail.com";

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void insertTest() {
        Users user = new Users();
        user.setName("mingyu");
        user.setPassword("123456");
        user.setEmail(this.testMail);
        userRepository.save(user);

        Users findUser = userRepository.findByEmail(this.testMail).get();
        assertThat(findUser.getName()).isEqualTo(user.getName());
    }

}