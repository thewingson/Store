package kz.almat.service.impl;

import kz.almat.exception.OrderDeleteException;
import kz.almat.model.Order;
import kz.almat.model.OrderProduct;
import kz.almat.model.Product;
import kz.almat.model.User;
import kz.almat.model.enums.OrderStatus;
import kz.almat.model.enums.Role;
import kz.almat.repo.OrderProductRepo;
import kz.almat.repo.OrderRepo;
import kz.almat.repo.ProductRepo;
import kz.almat.repo.UserRepo;
import kz.almat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@PropertySource(value = {"classpath:model.properties"})
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderProductRepo orderProductRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @Value("${error.order.status.approved}")
    private String ORDER_APPROVED;

    @Value("${error.order.status.delivered}")
    private String ORDER_DELIVERED;

    private final User currentUser = (User) SecurityContextHolder.getContext().getAuthentication();

    public List<Order> getAll() {

        if(currentUser.getAuthorities().contains(Role.ADMIN)){
            return orderRepo.getAll();
        }else {
            return orderRepo.getByUser(currentUser);
        }

    }

    public Order getById(Long id) {

        Order order = orderRepo.getById(id);

        if(currentUser.getAuthorities().contains(Role.ADMIN) || order.getUser().equals(currentUser)){
            return order;
        }else {
            return null;
        }
    }

    public Order getByIdWithProduct(Long id) {
        Order order = orderRepo.getByIdWithProduct(id);
        if(currentUser.getAuthorities().contains(Role.ADMIN) || order.getUser().equals(currentUser)){
            return order;
        }else {
            return null;
        }
    }

    public void add(Map<Long, Integer> cart) {

        User purchasedUser = userRepo.getByUsername(currentUser.getUsername());

        //creation of order
        Order order = new Order();
        order.setUser(purchasedUser);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getCreatedAt());
        calendar.add(Calendar.DATE, 7);
        order.setShipDate(new Timestamp(calendar.getTime().getTime()));
        order.setStatus(OrderStatus.PLACED);

        Long orderId = orderRepo.add(order);

        order.setId(orderId);

        for (Map.Entry<Long, Integer> c : cart.entrySet()) {
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

    public void delete(Order order, BindingResult bindingResult) {

        try {
            if (orderApproved(order)) {
                throw new OrderDeleteException(bindingResult, ORDER_APPROVED + order.getId());
            }
            if (orderDelivered(order)) {
                throw new OrderDeleteException(bindingResult, ORDER_DELIVERED + order.getId());
            }

            List<OrderProduct> orderProducts = order.getItems();

            for (OrderProduct op : orderProducts) {
                Product product = op.getProduct();
                product.setQuantity(product.getQuantity() + op.getQuantity());
                productRepo.edit(product);
            }
            orderRepo.delete(order);
        } catch (OrderDeleteException e) {
            e.printStackTrace();
        }
    }

    public void edit(Order order) {
        orderRepo.edit(order);
    }

    public void approve(Long id) {
        if(orderRepo.getById(id).getStatus().equals(OrderStatus.PLACED)){
            orderRepo.approve(id);
        }

    }

    public void delivered(Long id) {
        if(orderRepo.getById(id).getStatus().equals(OrderStatus.PLACED)){
            orderRepo.delivered(id);
        }
    }

    public void removeItem(Long orderId, Long itemId) {

        if (orderRepo.getById(orderId).getStatus().equals(OrderStatus.PLACED)) {
            orderProductRepo.removeItem(orderId, itemId);
        }
    }

    public void increase(Long orderId, Long itemId) {
        if (orderRepo.getById(orderId).getStatus().equals(OrderStatus.PLACED)) {
            OrderProduct orderProduct = orderProductRepo.getById(itemId);
            Product product = productRepo.getById(orderProduct.getProduct().getId());
            product.setQuantity(product.getQuantity() - 1);
            productRepo.edit(product);
            orderProductRepo.increase(itemId);
        }
    }

    public void decrease(Long orderId, Long itemId) {
        if (orderRepo.getById(orderId).getStatus().equals(OrderStatus.PLACED)) {
            OrderProduct orderProduct = orderProductRepo.getById(itemId);
            Product product = productRepo.getById(orderProduct.getProduct().getId());
            product.setQuantity(product.getQuantity() + 1);
            productRepo.edit(product);
            orderProductRepo.decrease(itemId);
        }
    }

    private boolean orderApproved(Order order) {
        return order.getStatus().equals(OrderStatus.APPROVED);
    }

    private boolean orderDelivered(Order order) {
        return order.getStatus().equals(OrderStatus.DELIVERED);
    }
}
