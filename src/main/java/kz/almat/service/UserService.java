package kz.almat.service;

import kz.almat.exception.EmailExistsException;
import kz.almat.exception.UsernameExistsException;
import kz.almat.model.User;
import kz.almat.model.dto.UserDTO;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long id);
    User add(UserDTO userDTO, BindingResult bindingResult) throws EmailExistsException, UsernameExistsException;
    void delete(User user);
    void edit(User user);
    User getByUsername(String username);
    User getByUsernameAndPassword(String username, String password);

}
