package kz.almat.service;

import kz.almat.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getAll();
    Order getById(Long id);
    void add(Map<Long, Integer> cart);
    void addOne(Long productId);
    void delete(Order order);
    void edit(Order order);

}
