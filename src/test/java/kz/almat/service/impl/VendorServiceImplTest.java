package kz.almat.service.impl;

import kz.almat.config.*;
import kz.almat.model.Vendor;
import kz.almat.repo.impl.VendorRepoImpl;
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
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, AppConfig.class, SecurityConfig.class, AppInit.class, SecurityInit.class})
@WebAppConfiguration
public class VendorServiceImplTest {

    @InjectMocks
    private VendorServiceImpl vendorService;

    @Mock
    private VendorRepoImpl vendorRepo;

    private List<Vendor> vendors;

    private Long id = 1L;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAll_returnsList() throws Exception {
        vendors = new ArrayList<>();
        vendors.add(new Vendor(null, "test1", null));

        Mockito.when(vendorRepo.getAll()).thenReturn(vendors);

        List<Vendor> result = vendorService.getAll();

        assertNotEquals(0, result.size());

    }

    @Test
    public void getAll_returnsNull() throws Exception {
        Mockito.when(vendorRepo.getAll()).thenReturn(null);

        List<Vendor> result = vendorService.getAll();

        assertNull(result);

    }

    @Test
    public void getById_returnsSimpleObject() throws Exception {
        Vendor vendor = new Vendor(id, "test1", null);

        Mockito.when(vendorRepo.getById(id)).thenReturn(vendor);

        Vendor result = vendorService.getById(id);

        assertNotNull(result);

    }

    @Test
    public void getById_returnsNull() throws Exception {

        Mockito.when(vendorRepo.getById(id)).thenReturn(null);

        Vendor result = vendorService.getById(id);

        assertNull(result);

    }
}