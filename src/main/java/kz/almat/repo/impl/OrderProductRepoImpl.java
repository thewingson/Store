package kz.almat.repo.impl;

import kz.almat.model.OrderProduct;
import kz.almat.repo.OrderProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepoImpl implements OrderProductRepo {

    @Autowired
    private SessionFactory sessionFactory;

    public List<OrderProduct> getAll() {
        return null;
    }

    public OrderProduct getById(Long id) {
        return null;
    }

    public void add(OrderProduct orderProduct) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(orderProduct);
    }

    public void delete(OrderProduct orderProduct) {

    }

    public void edit(OrderProduct orderProduct) {

    }
}
