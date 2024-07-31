package hello.hello_spring.java.order;

public interface OrderService {

    Order create(Long userId, String itemName, int itemPrice);
}
