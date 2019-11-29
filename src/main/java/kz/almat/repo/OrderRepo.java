package kz.almat.repo;

import kz.almat.model.Order;

import java.util.List;

public interface OrderRepo {

    List<Order> getAll();
    Order getById(Long id);
    Long add();
    void delete(Order order);
    void edit(Order order);
    void approve(Long id);
    void delivered(Long id);

}
