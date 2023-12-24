package users;

import java.util.Objects;

import enums.OrderStatus;

public class Order {
	String orderId;
	OrderStatus orderStatus;
	
	Order(String orderId, OrderStatus orderStatus) {
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
	
	public void changeOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Order order = (Order) o;
	    return Objects.equals(orderId, order.orderId);
	}

	public int hashCode() {
	    return Objects.hash(orderId);
	}

	
	
}