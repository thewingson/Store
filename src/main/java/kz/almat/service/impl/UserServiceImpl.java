package kz.almat.service.impl;

import kz.almat.model.User;
import kz.almat.repo.UserRepo;
import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAll() {
        return userRepo.getAll();
    }

    public User getById(Long id) {
        return userRepo.getById(id);
    }

    public void add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.add(user);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public void edit(User user) {
        userRepo.edit(user);
    }

    public User getByUsername(String username) {
        return userRepo.getByUsername(username);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userRepo.getByUsernameAndPassword(username, password);
    }
}
