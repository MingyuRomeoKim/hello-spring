package hello.hello_spring.java.discount;

import hello.hello_spring.java.user.Grade;
import hello.hello_spring.java.user.User;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int discount(User user, int price) {
        if (user.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
