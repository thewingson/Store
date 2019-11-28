package kz.almat.repo;

import kz.almat.model.User;

import java.util.List;

public interface UserRepo {

    List<User> getAll();
    User getById(Long id);
    void add(User user);
    void delete(User user);
    void edit(User user);

}
