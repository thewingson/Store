package kz.almat.repo.impl;

import kz.almat.model.Product;
import kz.almat.repo.ProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from Product ").list();
    }

    public Product getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
//        return (Product) session.createQuery(" from Product where id=:id").setParameter("id", id).list();
    }

    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
//        session.close();
    }

    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);

    }

    public void edit(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }
}
