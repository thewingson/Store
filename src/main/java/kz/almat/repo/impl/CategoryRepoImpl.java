package kz.almat.repo.impl;

import kz.almat.model.Category;
import kz.almat.model.Product;
import kz.almat.repo.CategoryRepo;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepoImpl implements CategoryRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from Category ").list();
    }

    public Category getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    public Category getByIdWithProducts(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, id);
        Hibernate.initialize(category.getProducts());

        return category;
    }

    public void add(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
    }

    public void delete(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }

    public void edit(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }
}
