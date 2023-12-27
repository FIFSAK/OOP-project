package users;

import java.io.Serializable;
import java.util.ArrayList;

import enums.OrderStatus;

public class TechSupport implements Serializable{
	
	private static TechSupport instance;
    private ArrayList<Order> orders;

    private TechSupport() {
        orders = new ArrayList<>();
    }

    public static TechSupport getInstance() {
        if (instance == null) {
            instance = new TechSupport();
        }
        return instance;
    }
    
    public void acceptOrder(Order order) {
    	order.changeOrderStatus(OrderStatus.ACCEPTED);
    	if (orders.contains(order)){
    		orders.add(order);
    	}
    }
    
    
    public void rejectOrder(Order order) {
    	order.changeOrderStatus(OrderStatus.ACCEPTED);
    	if (orders.contains(order)){
    		orders.add(order);
    	}
        
    }

	public void viewDoneAndAcceptedOrders() {
		orders.stream()
		.filter(order -> order.getOrderStatus() == OrderStatus.ACCEPTED)
        .map(order -> {
        	order.changeOrderStatus(OrderStatus.DONE);
            return order;
            })
        .toList();
	}

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
