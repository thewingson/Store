package kz.almat.service;

import kz.almat.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long id);
    void add(User user);
    void delete(User user);
    void edit(User user);

}
