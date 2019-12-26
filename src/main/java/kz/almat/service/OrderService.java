package kz.almat.service;

import kz.almat.model.Order;
import kz.almat.model.User;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getAll();
    Order getById(Long id);
    Order getByIdWithProduct(Long id);
    void add(Map<Long, Integer> cart);
    void delete(Order order, BindingResult bindingResult);
    void edit(Order order);
    void approve(Long id);
    void delivered(Long id);
    void removeItem(Long orderId, Long itemId);
    void increase(Long orderId, Long itemId);
    void decrease(Long orderId, Long itemId);

}
