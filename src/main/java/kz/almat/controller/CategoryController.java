package kz.almat.controller;

import kz.almat.model.Category;
import kz.almat.model.Product;
import kz.almat.service.CategoryService;
import kz.almat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    private ModelAndView getList(){
        List<Category> categories = categoryService.getAll();

        ModelAndView map = new ModelAndView("category/categories");
        map.addObject("categories", categories);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(){
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView getById(@PathVariable("id") Long id){

        Category category = categoryService.getById(id);

        ModelAndView map = new ModelAndView("category/category");
        map.addObject("category", category);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/products")
    public ModelAndView getProducts(@PathVariable("id") Long id){

        Category category = categoryService.getById(id);
        List<Product> products = productService.getByCategoryId(id);

        ModelAndView map = new ModelAndView("category/category");
        map.addObject("category", category);
        map.addObject("products", products);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create(){
        ModelAndView map = new ModelAndView("category/create");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("category") Category category){
        categoryService.add(category);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        Category category = categoryService.getById(id);
        categoryService.delete(category);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id){

        Category category = categoryService.getById(id);

        ModelAndView map = new ModelAndView("category/edit");
        map.addObject("category", category);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView update(@ModelAttribute("category") Category category){
        categoryService.edit(category);
        return getList();
    }

}
