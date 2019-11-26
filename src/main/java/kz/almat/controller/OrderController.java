package kz.almat.controller;

import kz.almat.model.Order;
import kz.almat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;

    private ModelAndView getList(){

        List<Order> orders = orderService.getAll();

        ModelAndView map = new ModelAndView("order/orders");
        map.addObject("orders", orders);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(){
        return getList();
    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/create")
//    public ModelAndView create(){
//        List<Category> categories = categoryService.getAll();
//        ModelAndView map = new ModelAndView("/create");
//        map.addObject("categories", categories);
//        return map;
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView create(@ModelAttribute("product") List<OrderProduct> orderProducts){
//        Category category = categoryService.getById(categoryId);
//        product.setCategory(category);
//        productService.add(product);
//        return getList();
//    }

}
