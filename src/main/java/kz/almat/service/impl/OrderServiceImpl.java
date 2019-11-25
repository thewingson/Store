package kz.almat.service.impl;

import kz.almat.model.Order;
import kz.almat.repo.OrderRepo;
import kz.almat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAll() {
        return orderRepo.getAll();
    }

    public Order getById(Long id) {
        return orderRepo.getById(id);
    }

    public void add(Order order) {
        orderRepo.add(order);
    }

    public void delete(Order order) {
        orderRepo.delete(order);
    }

    public void edit(Order order) {
        orderRepo.edit(order);
    }
}
