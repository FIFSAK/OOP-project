package users;

import java.io.Serializable;
import java.util.Objects;
import enums.OrderStatus;
import java.util.concurrent.atomic.AtomicInteger;

public class Order implements Serializable{
    private static int orderIdCounter = 1;

    private int orderId;
    private OrderStatus orderStatus;
    private String content;
    private Employee sender;

    public Order(String content, Employee sender) {
        this.orderId = orderIdCounter++;
        this.orderStatus = OrderStatus.PROCESSING;
        this.content = content;
        this.sender = sender;
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Employee getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
