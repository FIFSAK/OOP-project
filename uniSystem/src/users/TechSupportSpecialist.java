package users;

import java.util.ArrayList;

import enums.OrderStatus;

public class TechSupportSpecialist {
	
	private static TechSupportSpecialist instance;
    private ArrayList<Order> orders;

    private TechSupportSpecialist() {
        orders = new ArrayList<>();
    }

    public static TechSupportSpecialist getInstance() {
        if (instance == null) {
            instance = new TechSupportSpecialist();
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
		.filter(order -> order.orderStatus == OrderStatus.ACCEPTED)
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
