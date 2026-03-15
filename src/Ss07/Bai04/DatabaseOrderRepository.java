package Ss07.Bai04;

import java.util.*;

class DatabaseOrderRepository implements OrderRepository {

    List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu đơn hàng vào database: " + order.orderId);
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}