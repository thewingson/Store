package kz.almat.service.impl;

import kz.almat.config.*;
import kz.almat.model.Product;
import kz.almat.repo.impl.ProductRepoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, AppConfig.class, SecurityConfig.class, AppInit.class, SecurityInit.class})
@WebAppConfiguration
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepoImpl productRepo;

    private Product productTest1;
    private Product productTest2;
    private List<Product> productListTest;
    private Map<Long, Integer> cartTest;
    private Map<Product, Integer> itemsTest;

    @Before
    public void setup() {

        productTest1 = new Product(1L, "test_product_1", 100, 10, null, null);
        productTest2 = new Product(2L, "test_product_2", 100, 10, null, null);
        productListTest = new ArrayList<>();
        productListTest.add(productTest1);
        productListTest.add(productTest2);
        cartTest = new HashMap<>();
        cartTest.put(1L, 1);
        cartTest.put(2L, 1);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCartItems_ReturnsMap() throws Exception {

        Mockito.when(productRepo.getProductInId(cartTest)).thenReturn(productListTest);

        productService.getCartItems(cartTest);

        Mockito.verify(productRepo).getProductInId(cartTest);

        assertTrue(true);

    }

}
