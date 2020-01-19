package kz.almat.controller;

import kz.almat.config.*;
import kz.almat.model.Vendor;
import kz.almat.service.impl.VendorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Almat on 19.01.2020
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, AppConfig.class, SecurityConfig.class, AppInit.class, SecurityInit.class})
@WebAppConfiguration
//@TestPropertySource("/application-test.properties")
//@Sql(value = {"/create-user-before.sql", "/messages-list-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/messages-list-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class VendorControllerTest {

    @InjectMocks
    private VendorController vendorController;

    @Mock
    private VendorServiceImpl vendorService;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(vendorController).build();
    }

    @Test
    public void getAll_returnsList() throws Exception {

        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor(1L, "test1", null));
        vendors.add(new Vendor(2L, "test2", null));

        when(vendorService.getAll()).thenReturn(vendors);

        mockMvc.perform(get("/vendors"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/vendors/vendors"))
                .andExpect(model().attribute("vendors", hasSize(2)))
                .andExpect(model().attribute("vendors", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("name", is("test1"))
                        )
                )))
                .andExpect(model().attribute("vendors", hasItem(
                        allOf(
                                hasProperty("id", is(2L)),
                                hasProperty("name", is("test2"))
                        )
                )));
    }

    @Test
    public void getById_returnsSimpleResult() throws Exception {

        Vendor vendor = new Vendor(1L, "test1", null);

        when(vendorService.getById(1L)).thenReturn(vendor);

        mockMvc.perform(get("/vendors/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/vendors/vendors"))
                .andExpect(model().attribute("vendor", hasProperty("id", is(1L))))
                .andExpect(model().attribute("vendor", hasProperty("name", is("test1"))));
    }

    @Test
    public void delete_redirects() throws Exception {

        this.mockMvc.perform(get("/vendors/delete/{id}", anyLong()))
                .andExpect(status().is3xxRedirection());

        verify(vendorService).delete(anyLong());
    }

    @Test
    public void create_redirects() throws Exception {

        Vendor vendor = new Vendor(1L, "test1", null);

        this.mockMvc.perform(post("/vendors")
                .flashAttr("vendor", vendor))
                .andExpect(status().is3xxRedirection());

        verify(vendorService).add(vendor);
    }

    @Test
    public void update_redirects() throws Exception {

        Vendor vendor = new Vendor(1L, "test1", null);

        this.mockMvc.perform(post("/vendors/update/{id}", 1L)
                .flashAttr("vendor", vendor))
                .andExpect(status().is3xxRedirection());

        verify(vendorService).edit(vendor);
    }

}
