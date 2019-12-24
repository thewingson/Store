package kz.almat.repo.impl;

import kz.almat.model.Order;
import kz.almat.model.enums.OrderStatus;
import kz.almat.repo.OrderRepo;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Calendar;
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

    public Order getByIdWithProduct(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        Hibernate.initialize(order.getItems());

        return order;
    }

    public Long add(Order order) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(order);
    }

    public void delete(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(order);
    }

    public void edit(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }

    public void approve(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Update Order set status =: status where id =: id");
        query.setParameter("status", OrderStatus.APPROVED);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public void delivered(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Update Order set status =: status where id =: id");
        query.setParameter("status", OrderStatus.DELIVERED);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
