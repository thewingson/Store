package kz.almat.repo.impl;

import kz.almat.model.Vendor;
import kz.almat.repo.VendorRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendorRepoImpl implements VendorRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Vendor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from Vendor ").list();
    }

    public Vendor getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Vendor.class, id);
    }

    public void add(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(vendor);
    }

    public void delete(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(vendor);

    }

    public void edit(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vendor);
    }
}
