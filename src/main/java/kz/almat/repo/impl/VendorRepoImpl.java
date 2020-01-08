package kz.almat.repo.impl;

import kz.almat.model.Vendor;
import kz.almat.repo.VendorRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class VendorRepoImpl implements VendorRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Vendor getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Vendor) session.createQuery(" select v from Vendor v where v.id=:id ").setParameter("id", id).uniqueResult();
    }

    @Override
    public List<Vendor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" select v from Vendor v ").list();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery(" delete from Vendor v where v.id=:id ").setParameter("id", id).executeUpdate();
    }

    @Override
    public void create(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(vendor);
    }

    @Override
    public void update(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery(" update Vendor v set v.name = :name where v.id=:id ").setParameter("name", vendor.getName()).executeUpdate();
    }

}
