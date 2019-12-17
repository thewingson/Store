package kz.almat.service.impl;

import kz.almat.exception.EmailExistsException;
import kz.almat.exception.UsernameExistsException;
import kz.almat.model.User;
import kz.almat.model.dto.UserDTO;
import kz.almat.model.enums.Role;
import kz.almat.repo.UserRepo;
import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public User add(UserDTO userDTO, BindingResult result) {

        User registered = null;
        if (emailExist(userDTO.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            +  userDTO.getEmail());
        } if(usernameExist(userDTO.getUsername())) {
            throw new UsernameExistsException(
                    "There is an account with that username: "
                            +  userDTO.getUsername());
        }
        else {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            user.setFirstName(userDTO.getPassword());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());

            Set<Role> roles = new HashSet<Role>();
            roles.add(Role.USER);
            user.setRoles(roles);
            registered = userRepo.getById(userRepo.add(user));
        }
        return registered;
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

    private boolean emailExist(String email) {
        return userRepo.getByEmail(email) != null;
    }

    private boolean usernameExist(String username) {
        return userRepo.getByUsername(username) != null;
    }
}
