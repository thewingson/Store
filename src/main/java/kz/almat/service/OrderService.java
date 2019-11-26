package kz.almat.service;

import kz.almat.model.Order;
import kz.almat.model.Product;
import kz.almat.model.dto.ProductDTO;

import java.util.List;

public interface OrderService {

    List<Order> getAll();
    Order getById(Long id);
    void add(List<ProductDTO> products);
    void addOne(Product products);
    void delete(Order order);
    void edit(Order order);

}
