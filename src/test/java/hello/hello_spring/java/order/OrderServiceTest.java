package hello.hello_spring.java.order;

import hello.hello_spring.java.user.Grade;
import hello.hello_spring.java.user.User;
import hello.hello_spring.java.user.UserService;
import hello.hello_spring.java.user.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    UserService userService = new UserServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder () {

        Long userId = 1L;
        User user = new User(userId, "mingyu", "mingyu@test.com", Grade.VIP);
        userService.join(user);

        Order order = orderService.create(userId,"item1",10000);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
