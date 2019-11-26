package kz.almat.controller;

import kz.almat.model.Order;
import kz.almat.model.dto.ProductDTO;
import kz.almat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpSession httpSession;

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

//    @RequestMapping(method = RequestMethod.GET, value = "/create")
//    public ModelAndView create(){
//        List<Category> categories = categoryService.getAll();
//        ModelAndView map = new ModelAndView("/create");
//        map.addObject("categories", categories);
//        return map;
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public int create(@ModelAttribute("products") List<ProductDTO> products){
////        orderService.add(products);
////        return getList();
//        return products.size();
//    }

//    @RequestMapping(method = RequestMethod.POST, value = "/addToCart")
//    public int addToCart(@ModelAttribute("productId") Long productId ){
//
//        httpSession.setAttribute();
//
//        return 0;
//    }

}
