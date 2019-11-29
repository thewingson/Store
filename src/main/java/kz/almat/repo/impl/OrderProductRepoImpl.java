package kz.almat.repo.impl;

import kz.almat.model.OrderProduct;
import kz.almat.model.enums.OrderStatus;
import kz.almat.repo.OrderProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        Session session = sessionFactory.getCurrentSession();
        return session.get(OrderProduct.class, id);
    }

    public void add(OrderProduct orderProduct) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(orderProduct);
    }

    public void delete(OrderProduct orderProduct) {

    }

    public void edit(OrderProduct orderProduct) {

    }

    public void removeItem(Long orderId, Long itemId) {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("delete from OrderProduct where order.id =: orderId and product.id =: itemId");
            query.setParameter("orderId", orderId);
            query.setParameter("itemId", itemId);
            query.executeUpdate();
    }

    public void increase(Long itemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update OrderProduct set quantity=quantity+1 where id =: itemId");
        query.setParameter("itemId", itemId);
        query.executeUpdate();
    }

    public void decrease(Long itemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update OrderProduct set quantity=quantity-1 where id =: itemId");
        query.setParameter("itemId", itemId);
        query.executeUpdate();
    }
}
