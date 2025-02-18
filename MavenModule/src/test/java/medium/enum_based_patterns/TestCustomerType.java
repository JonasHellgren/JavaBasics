package medium.enum_based_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCustomerType {

    @Test
    void whenRegular_thenCorrect() {
        double discount = CustomerType.REGULAR.calculateDiscountedPrice(100);
        Assertions.assertEquals(100, discount);
    }

    @Test
    void whenMember_thenCorrect() {
        double discount = CustomerType.MEMBER.calculateDiscountedPrice(100);
        Assertions.assertEquals(90, discount);
    }

    @Test
    void whenVip_thenCorrect() {
        double discount = CustomerType.VIP.calculateDiscountedPrice(100);
        Assertions.assertEquals(80, discount);
    }
}