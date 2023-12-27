package users;

import java.io.Serializable;
import java.util.Objects;
import enums.OrderStatus;
import java.util.concurrent.atomic.AtomicInteger;


import java.util.Objects;

/**
 * The Order class represents an order made by an employee.
 */
public class Order implements Serializable{

    private static int orderIdCounter = 1;

    private int orderId;
    private OrderStatus orderStatus;
    private String content;
    private Employee sender;

    /**
     * Constructs an Order object with the specified content and sender.
     *
     * @param content The content of the order.
     * @param sender  The employee who created the order.
     */
    public Order(String content, Employee sender) {
        this.orderId = orderIdCounter++;
        this.orderStatus = OrderStatus.PROCESSING;
        this.content = content;
        this.sender = sender;
    }

    /**
     * Changes the status of the order.
     *
     * @param orderStatus The new status of the order.
     */
    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Gets the sender of the order.
     *
     * @return The employee who created the order.
     */
    public Employee getSender() {
        return sender;
    }

    /**
     * Gets the content of the order.
     *
     * @return The content of the order.
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the status of the order.
     *
     * @return The status of the order.
     */
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Checks if two orders are equal based on their order ID.
     *
     * @param o The object to compare with.
     * @return True if the orders are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    /**
     * Generates a hash code for the order based on its order ID.
     *
     * @return The hash code for the order.
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
