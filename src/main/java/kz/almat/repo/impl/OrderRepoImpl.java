package kz.almat.repo.impl;

import kz.almat.model.Order;
import kz.almat.repo.OrderRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepoImpl implements OrderRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from Order ").list();
    }

    public Order getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    public void add(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
    }

    public void delete(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(order);
    }

    public void edit(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }
}
