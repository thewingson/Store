package kz.almat.repo;

import kz.almat.model.OrderProduct;

import java.util.List;

public interface OrderProductRepo {

    List<OrderProduct> getAll();

    OrderProduct getById(Long id);

    void add(OrderProduct orderProduct);

    void delete(OrderProduct orderProduct);

    void edit(OrderProduct orderProduct);

    void removeItem(Long orderId, Long itemId);

    void increase(Long itemId);

    void decrease(Long itemId);
}
