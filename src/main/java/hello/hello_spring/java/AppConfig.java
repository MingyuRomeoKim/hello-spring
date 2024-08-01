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
import jdk.jfr.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(userRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
