package hello.hello_spring.java.order;

import hello.hello_spring.java.AppConfig;
import hello.hello_spring.java.user.Grade;
import hello.hello_spring.java.user.User;
import hello.hello_spring.java.user.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean("userService",UserService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

        Long userId = 1L;
        User user = new User(userId, "mingyu", "mingyu@test.com", Grade.VIP);
        userService.join(user);

        Order order = orderService.create(userId,"item1",10000);

        System.out.println(order.toString());
        System.out.println(order.calculatePrice());
    }
}
