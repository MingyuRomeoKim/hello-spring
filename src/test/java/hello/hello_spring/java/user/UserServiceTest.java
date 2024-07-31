package hello.hello_spring.java.user;

import hello.hello_spring.java.AppConfig;
import hello.hello_spring.java.user.Grade;
import hello.hello_spring.java.user.User;
import hello.hello_spring.java.user.UserService;
import hello.hello_spring.java.user.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    AppConfig appConfig = new AppConfig();
    UserService userService = appConfig.userService();

    @Test
    void join() {
        User user = new User(1L,"mingyuTest","mingyuTest@kimmingyu.co.kr", Grade.VIP);
        userService.join(user);

        User findUser = userService.findUser(1L);

        Assertions.assertThat(user).isEqualTo(findUser);
    }
}
