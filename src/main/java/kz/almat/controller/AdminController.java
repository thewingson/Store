package kz.almat.controller;

import kz.almat.model.*;
import kz.almat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = {"/products", ""})
    public ModelAndView getProducts(){

        List<Product> products = productService.getAll();

        ModelAndView map = new ModelAndView("admin/products/products");
        map.addObject("products", products);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    public ModelAndView getCategories(){

        List<Category> categories = categoryService.getAll();

        ModelAndView map = new ModelAndView("admin/categories/categories");
        map.addObject("categories", categories);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView getUsers(){

        List<User> users = userService.getAll();

        ModelAndView map = new ModelAndView("admin/users/users");
        map.addObject("users", users);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vendors")
    public ModelAndView getVendors(){

        List<Vendor> vendors = vendorService.getAll();

        ModelAndView map = new ModelAndView("admin/vendors/vendors");
        map.addObject("vendors", vendors);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public ModelAndView getOrders(){

        List<Order> orders = orderService.getAll();

        ModelAndView map = new ModelAndView("admin/orders/orders");
        map.addObject("orders", orders);

        return map;
    }

}
