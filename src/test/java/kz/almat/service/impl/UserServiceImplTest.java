package kz.almat.service.impl;

import kz.almat.config.*;
import kz.almat.exception.EmailExistsException;
import kz.almat.model.User;
import kz.almat.model.dto.UserDTO;
import kz.almat.repo.impl.UserRepoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, AppConfig.class, SecurityConfig.class, AppInit.class, SecurityInit.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepoImpl userRepo;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserDTO userDTO;
    private User userToRegister;
    private BindingResult bindingResult;
    private String email = "test_email";
    private String username = "test_username";
    private String password = "test_password";
    private String confirmPassword = "test_confirm_password";
    private String firstName = "test_firstname";
    private String lastName = "test_lastname";
    private String phone = "87777777777";
    private String encryptedPassword = "test_encrypted_password";
    private Long id = 1L;
    private String EMAIL_EXIST = "There is an account with that email address:";
    private String USERNAME_EXIST = "There is an account with that username:";
    private String PHONE_EXIST = "There is an account with that phone number:";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void add_RegistrationPassed() throws Exception {
        userDTO = new UserDTO(username, password, confirmPassword, firstName, lastName, email, phone);

        User user = new User(1L, username, firstName, lastName, email, password, phone, null, null);

        when(userRepo.getByEmail(email)).thenReturn(null);
        when(userRepo.getByUsername(username)).thenReturn(null);
        when(userRepo.getByPhone(phone)).thenReturn(null);
        when(bCryptPasswordEncoder.encode(userDTO.getPassword())).thenReturn(encryptedPassword);
        when(userRepo.add(user)).thenReturn(id);

        User result = userService.add(userDTO, bindingResult);

        verify(bCryptPasswordEncoder).encode(userDTO.getPassword());
        verify(userRepo).add(user);
        verify(userRepo).getById(id);

        assertEquals(userToRegister, result);
    }

//    @Test(expected = EmailExistsException.class)
//    public void add_emailExistException() throws EmailExistsException {
//        userDTO = new UserDTO(username, password, confirmPassword, firstName, lastName, email, phone);
//
//        User user = new User(1L, username, firstName, lastName, email, password, phone, null, null);
//
//        bindingResult = new MapBindingResult(new HashMap<String, Object>(), "email");
//
//        when(userRepo.getByEmail(email)).thenReturn(user);
//
//        User result = userService.add(userDTO, bindingResult);
//        assertEquals(null, result);
//
//    }

}
