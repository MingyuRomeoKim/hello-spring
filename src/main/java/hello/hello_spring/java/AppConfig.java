package hello.hello_spring.java;

import hello.hello_spring.java.discount.FixDiscountPolicy;
import hello.hello_spring.java.order.OrderService;
import hello.hello_spring.java.order.OrderServiceImpl;
import hello.hello_spring.java.user.MemoryUserRepository;
import hello.hello_spring.java.user.UserService;
import hello.hello_spring.java.user.UserServiceImpl;

public class AppConfig {

    public UserService userService() {
        return new UserServiceImpl(new MemoryUserRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryUserRepository(), new FixDiscountPolicy());
    }
}
