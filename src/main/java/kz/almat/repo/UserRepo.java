package kz.almat.repo;

import kz.almat.model.User;

import java.util.List;

public interface UserRepo {

    List<User> getAll();

    User getById(Long id);

    Long add(User user);

    void delete(User user);

    void edit(User user);

    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    User getByEmail(String email);

    User getByPhone(String phone);
}
