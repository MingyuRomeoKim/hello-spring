package hello.hello_spring.java;

import hello.hello_spring.java.discount.DiscountPolicy;
import hello.hello_spring.java.discount.FixDiscountPolicy;
import hello.hello_spring.java.discount.RateDiscountPolicy;
import hello.hello_spring.java.order.OrderService;
import hello.hello_spring.java.order.OrderServiceImpl;
import hello.hello_spring.java.user.MemoryUserRepository;
import hello.hello_spring.java.user.UserRepository;
import hello.hello_spring.java.user.UserService;
import hello.hello_spring.java.user.UserServiceImpl;

public class AppConfig {

    public UserService userService() {
        return new UserServiceImpl(memberRepository());
    }

    private UserRepository memberRepository() {
        return new MemoryUserRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
