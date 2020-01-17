package kz.almat.service.impl;

import kz.almat.config.*;
import kz.almat.model.Order;
import kz.almat.model.OrderProduct;
import kz.almat.model.Product;
import kz.almat.model.User;
import kz.almat.model.enums.OrderStatus;
import kz.almat.model.enums.Role;
import kz.almat.repo.impl.OrderProductRepoImpl;
import kz.almat.repo.impl.OrderRepoImpl;
import kz.almat.repo.impl.ProductRepoImpl;
import kz.almat.repo.impl.UserRepoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Almat on 15.01.2020
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, AppConfig.class, SecurityConfig.class, AppInit.class, SecurityInit.class})
@WebAppConfiguration
public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepoImpl orderRepo;
    @Mock
    private OrderProductRepoImpl orderProductRepo;
    @Mock
    private ProductRepoImpl productRepo;
    @Mock
    private UserRepoImpl userRepo;

    private Order orderTest1;
    private Order orderTest2;
    private Order orderTest3;

    private User currentUser;

    @Mock
    private Calendar calendar;

    @Before
    public void setup() {
        orderTest1 = new Order();
        orderTest1.setId(1L);
        orderTest2 = new Order();
        orderTest1.setId(2L);
        orderTest3 = new Order();
        orderTest1.setId(3L);

        currentUser = new User();
        currentUser.setId(1L);
        currentUser.setFirstName("test1");
        currentUser.setLastName("test1");
        currentUser.setEmail("test1@mail.ru");
        currentUser.setPhone("87776665544");
        currentUser.setUsername("test1");
        currentUser.setPassword("123456789");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAll_currentUser() throws Exception {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        currentUser.setRoles(roles);

        orderTest1.setUser(currentUser);
        List<Order> orders = new ArrayList<>();
        orders.add(orderTest1);

        Mockito.when(orderRepo.getByUser(currentUser)).thenReturn(orders);

        List<Order> result = orderService.getAll(currentUser);

        Mockito.verify(orderRepo).getByUser(currentUser);

        assertEquals(currentUser, result.get(0).getUser());
    }

    @Test
    public void getAll_admin() throws Exception {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMIN);
        currentUser.setRoles(roles);

        orderTest1.setUser(currentUser);
        List<Order> orders = new ArrayList<>();
        orders.add(orderTest1);

        Mockito.when(orderRepo.getAll()).thenReturn(orders);

        List<Order> result = orderService.getAll(currentUser);

        Mockito.verify(orderRepo, Mockito.times(1)).getAll();

        assertEquals(currentUser, result.get(0).getUser());
    }

//    @Test
//    public void add_currentUser() throws Exception {
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.USER);
//        currentUser.setRoles(roles);
//
//        Order order = new Order();
//        order.setUser(currentUser);
//        calendar.setTime(order.getCreatedAt());
//        calendar.add(Calendar.DATE, 7);
//        order.setShipDate(new Timestamp(calendar.getTime().getTime()));
//        order.setStatus(OrderStatus.PLACED);
//
//        Map<Long, Integer> cart = new HashMap<>();
//        cart.put(1L, 1);
//        cart.put(2L, 2);
//
//        Product product = new Product();
//        product.setName("test1");
//        product.setPrice(100);
//        product.setQuantity(100);
//        product.setVendor(null);
//        product.setCategory(null);
//
//        Mockito.when(productRepo.getById(Matchers.anyLong())).thenReturn(product);
//
//        orderService.add(cart, currentUser);
//
//        Mockito.verify(orderRepo).add(order);
//        Mockito.verify(productRepo, Mockito.times(2)).getById(Matchers.anyLong());
//        Mockito.verify(productRepo, Mockito.times(2)).edit(Matchers.any(Product.class));
//        Mockito.verify(orderProductRepo, Mockito.times(2)).add(Matchers.any(OrderProduct.class));
//    }

}
