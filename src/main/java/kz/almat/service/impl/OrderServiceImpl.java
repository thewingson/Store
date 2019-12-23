package kz.almat.service.impl;

import kz.almat.model.Order;
import kz.almat.model.OrderProduct;
import kz.almat.model.Product;
import kz.almat.repo.OrderProductRepo;
import kz.almat.repo.OrderRepo;
import kz.almat.repo.ProductRepo;
import kz.almat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderProductRepo orderProductRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<Order> getAll() {
        return orderRepo.getAll();
    }

    public Order getById(Long id) {
        return orderRepo.getById(id);
    }

    public Order getByIdWithProduct(Long id) {
        return orderRepo.getByIdWithProduct(id);
    }

    public void add(Map<Long, Integer> cart) {
        //creation of order
        Long orderId = orderRepo.add();
        Order order = new Order();
        order.setId(orderId);

        for(Map.Entry<Long, Integer> c : cart.entrySet()){
            // decrement of product quantity
            Product productToBuy = productRepo.getById(c.getKey());
            productToBuy.setQuantity(productToBuy.getQuantity() - c.getValue());
            productRepo.edit(productToBuy);

            // new OrderProduct
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(productToBuy);
            orderProduct.setQuantity(c.getValue());
            orderProductRepo.add(orderProduct);
        }

    }

    public void addOne(Long productId) {

    }

    public void delete(Order order) {

        List<OrderProduct> orderProducts = order.getItems();

        for (OrderProduct op : orderProducts){
            Product product = op.getProduct();
            product.setQuantity(product.getQuantity() + op.getQuantity());
            productRepo.edit(product);
        }

        orderRepo.delete(order);
    }

    public void edit(Order order) {
        orderRepo.edit(order);
    }

    public void approve(Long id) {
        orderRepo.approve(id);
    }

    public void delivered(Long id) {
        orderRepo.delivered(id);
    }

    public void removeItem(Long orderId, Long itemId) {
        orderProductRepo.removeItem(orderId, itemId);
    }

    public void increase(Long itemId) {
        OrderProduct orderProduct = orderProductRepo.getById(itemId);
        Product product = productRepo.getById(orderProduct.getProduct().getId());
        product.setQuantity(product.getQuantity() - 1);
        productRepo.edit(product);
        orderProductRepo.increase(itemId);
    }

    public void decrease(Long itemId) {
        OrderProduct orderProduct = orderProductRepo.getById(itemId);
        Product product = productRepo.getById(orderProduct.getProduct().getId());
        product.setQuantity(product.getQuantity() + 1);
        productRepo.edit(product);
        orderProductRepo.decrease(itemId);
    }
}
