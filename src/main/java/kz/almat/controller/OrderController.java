package kz.almat.controller;

import kz.almat.model.Order;
import kz.almat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET, value = "/addToCart/{id}")
    public void addToCart(@PathVariable(value = "id") Long id,
                                  HttpSession session){
        Map<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
        if(cart.containsKey(id)){
            cart.put(id, cart.get(id) + 1);
        } else {
            cart.put(id, 1);
        }

        session.setAttribute("cart", cart);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart")
    public ModelAndView cart(){

        ModelAndView map = new ModelAndView("order/cart");

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/purchase")
    public ModelAndView purchase(HttpSession session){

        Map<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
        orderService.add(cart);
        session.setAttribute("cart", new HashMap<Long, Integer>());

        return getList();
    }

}
