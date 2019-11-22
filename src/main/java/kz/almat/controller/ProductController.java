package kz.almat.controller;

import kz.almat.model.Category;
import kz.almat.model.Product;
import kz.almat.service.CategoryService;
import kz.almat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/products", "", "/"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    private ModelAndView getList(){

        List<Product> products = productService.getAll();
        List<Category> categories = categoryService.getAll();

        ModelAndView map = new ModelAndView("product/products");
        map.addObject("products", products);
        map.addObject("categories", categories);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(){
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
        ModelAndView map = new ModelAndView("product/create");
        map.addObject("categories", categories);
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("product") Product product,
                               @RequestParam(value = "categoryId") Long categoryId){
        Category category = categoryService.getById(categoryId);
        product.setCategory(category);
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
        ModelAndView map = new ModelAndView("product/edit");
        map.addObject("categories", categories);
        map.addObject("product", product);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView update(@ModelAttribute("product") Product product,
                               @RequestParam(value = "categoryId") Long categoryId){
        Category category = categoryService.getById(categoryId);
        product.setCategory(category);
        productService.edit(product);
        return getList();
    }

}
