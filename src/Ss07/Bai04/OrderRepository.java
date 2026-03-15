package Ss07.Bai04;

import java.util.List;

interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}