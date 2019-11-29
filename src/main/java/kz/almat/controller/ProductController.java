package kz.almat.controller;

import kz.almat.model.Category;
import kz.almat.model.Product;
import kz.almat.model.Vendor;
import kz.almat.service.CategoryService;
import kz.almat.service.ProductService;
import kz.almat.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/products", "", "/"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private VendorService vendorService;

    private ModelAndView getList(){

        List<Product> products = productService.getAll();

        ModelAndView map = new ModelAndView("product/products");
        map.addObject("products", products);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(HttpSession session){

        if(session.getAttribute("cart") == null){
            Map<Long, Integer> cart = new HashMap<Long, Integer>();
            session.setAttribute("cart", cart);
        }

        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView getById(@PathVariable("id") Long id){

        Product product = productService.getById(id);

        ModelAndView map = new ModelAndView("product/product");
        map.addObject("product", product);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create(){
        List<Category> categories = categoryService.getAll();
        List<Vendor> vendors = vendorService.getAll();
        ModelAndView map = new ModelAndView("product/create");
        map.addObject("categories", categories);
        map.addObject("vendors", vendors);
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("product") Product product,
                               @RequestParam(value = "categoryId") Long categoryId,
                               @RequestParam(value = "vendorId") Long vendorId){
        Category category = categoryService.getById(categoryId);
        Vendor vendor= vendorService.getById(vendorId);
        product.setCategory(category);
        product.setVendor(vendor);
        productService.add(product);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        Product product = productService.getById(id);
        productService.delete(product);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id){

        Product product = productService.getById(id);
        List<Category> categories = categoryService.getAll();
        List<Vendor> vendors = vendorService.getAll();
        ModelAndView map = new ModelAndView("product/edit");
        map.addObject("categories", categories);
        map.addObject("vendors", vendors);
        map.addObject("product", product);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView update(@ModelAttribute("product") Product product,
                               @RequestParam(value = "categoryId") Long categoryId,
                               @RequestParam(value = "vendorId") Long vendorId){
        Category category = categoryService.getById(categoryId);
        Vendor vendor = vendorService.getById(vendorId);
        product.setCategory(category);
        product.setVendor(vendor);
        productService.edit(product);
        return getList();
    }

}
