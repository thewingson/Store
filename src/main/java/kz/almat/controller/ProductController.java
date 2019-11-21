package kz.almat.controller;

import kz.almat.model.Product;
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
@RequestMapping(value = {"/products", "", "/"})
public class ProductController {

    @Autowired
    private ProductService productService;



    private ModelAndView getList(){

        List<Product> products = productService.getAll();

        ModelAndView map = new ModelAndView("product/products");
        map.addObject("products", products);

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
        ModelAndView map = new ModelAndView("product/create");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("product") Product product){
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

        ModelAndView map = new ModelAndView("product/edit");
        map.addObject("product", product);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView update(@ModelAttribute("product") Product product){
        productService.edit(product);
        return getList();
    }

}
