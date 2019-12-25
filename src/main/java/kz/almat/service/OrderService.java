package kz.almat.service;

import kz.almat.model.Order;
import kz.almat.model.User;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getAll();
    Order getById(Long id);
    Order getByIdWithProduct(Long id);
    void add(Map<Long, Integer> cart, User user);
    void delete(Order order);
    void edit(Order order);
    void approve(Long id);
    void delivered(Long id);
    void removeItem(Long orderId, Long itemId);
    void increase(Long itemId);
    void decrease(Long itemId);

}
