package kz.almat.repo;

import kz.almat.model.Order;
import kz.almat.model.User;

import java.util.List;

public interface OrderRepo {

    List<Order> getAll();
    Order getById(Long id);
    List<Order> getByUser(User user);
    Order getByIdWithProduct(Long id);
    Long add(Order order);
    void delete(Order order);
    void edit(Order order);
    void approve(Long id);
    void delivered(Long id);

}
