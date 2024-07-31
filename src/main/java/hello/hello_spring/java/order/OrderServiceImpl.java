package hello.hello_spring.java.order;

import hello.hello_spring.java.discount.DiscountPolicy;
import hello.hello_spring.java.discount.FixDiscountPolicy;
import hello.hello_spring.java.user.MemoryUserRepository;
import hello.hello_spring.java.user.User;
import hello.hello_spring.java.user.UserRepository;

public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository = new MemoryUserRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order create(Long userId, String itemName, int itemPrice) {
        User user = userRepository.findById(userId);
        int discountPrice = discountPolicy.discount(user, itemPrice);

        return new Order(userId, itemName, itemPrice, discountPrice);
    }
}
