package hello.hello_spring.java.discount;

import hello.hello_spring.java.user.Grade;
import hello.hello_spring.java.user.User;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;

    @Override
    public int discount(User user, int price) {
        if (user.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
