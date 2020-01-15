package kz.almat.service;

import kz.almat.model.Order;
import kz.almat.model.User;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getAll(User user);
    Order getById(Long id, User user);
    Order getByIdWithProduct(Long id, User user);
    void add(Map<Long, Integer> cart, User user);
    void delete(Order order, BindingResult bindingResult, User user);
    void approve(Long id, User user);
    void delivered(Long id, User user);
    void removeItem(Long orderId, Long itemId, User user);
    void increase(Long orderId, Long itemId, User user);
    void decrease(Long orderId, Long itemId, User user);

}
