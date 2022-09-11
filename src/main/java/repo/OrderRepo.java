package repo;

import model.Order;
import java.util.HashMap;
import java.util.Map;

public class OrderRepo {
    Map<Integer, Order> orders = new HashMap<>();

    public Map<Integer, Order> list(){
        return orders;
    }

    public Order get(int id){
        return orders.get(id);
    }

    public Map<Integer, Order> add(Order order){
        orders.put(order.getOrderId(), order);
        return orders;
    }

}
