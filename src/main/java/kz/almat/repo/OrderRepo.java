package kz.almat.repo;

import kz.almat.model.Order;

import java.util.List;

public interface OrderRepo {

    List<Order> getAll();
    Order getById(Long id);
    void add(Order order);
    void delete(Order order);
    void edit(Order order);

}