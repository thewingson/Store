package kz.almat.repo.impl;

import kz.almat.model.User;
import kz.almat.repo.UserRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from User ").list();
    }

    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @SuppressWarnings("unchecked")
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =: username");
        query.setParameter("username", username);
        List<User> userList = query.list();
        return userList.get(0);
    }

    @SuppressWarnings("unchecked")
    public User getByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =: username and password =: password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<User> userList = query.list();
        return userList.get(0);
    }
}
