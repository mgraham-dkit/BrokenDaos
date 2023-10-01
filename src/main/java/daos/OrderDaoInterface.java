package daos;

import business.Order;

import java.util.List;

public interface OrderDaoInterface {
    public Order getOrderById(int id);
    public List<Order> getAllOrders();
}
