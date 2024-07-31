package hello.hello_spring.java.discount;

import hello.hello_spring.java.user.Grade;
import hello.hello_spring.java.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% Discount Check")
    void vip_discount_test() {
        User vipUser = new User(1L,"mingyu","mingyu@test.com", Grade.VIP);

        int vipDiscount = discountPolicy.discount(vipUser,10000);
        int vip2Discount = discountPolicy.discount(vipUser,30000);

        Assertions.assertThat(vipDiscount).isEqualTo(1000);
        Assertions.assertThat(vip2Discount).isEqualTo(3000);
    }

    @Test
    @DisplayName("BASIC Can't Discount Check")
    void basic_discount_test() {
        User basicUser = new User(1L,"mingyu","mingyu@test.com", Grade.BASIC);

        int basicDiscount = discountPolicy.discount(basicUser,10000);

        Assertions.assertThat(basicDiscount).isEqualTo(0);
    }
}