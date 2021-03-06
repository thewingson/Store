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
@SuppressWarnings("unchecked")
public class UserRepoImpl implements UserRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from User ").list();
    }

    @Override
    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public Long add(User user) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =: username");
        query.setParameter("username", username);
        List<User> userList = query.list();
        if(userList.size() != 0){
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =: username and password =: password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setMaxResults(1);
        List<User> userList = query.list();
        if(userList != null){
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email =: email");
        query.setParameter("email", email);
        List<User> userList = query.list();
        if(userList.size() != 0){
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getByPhone(String phone) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where phone =: phone");
        query.setParameter("phone", phone);
        List<User> userList = query.list();
        if(userList.size() != 0){
            return userList.get(0);
        } else {
            return null;
        }
    }
}
