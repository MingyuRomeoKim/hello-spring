package hello.hello_spring.java.discount;

import hello.hello_spring.java.user.User;

public interface DiscountPolicy {

    /**
     *
     * @param user
     * @param price
     * @return 할인 대상 금액
     */
    int discount(User user, int price);

}
