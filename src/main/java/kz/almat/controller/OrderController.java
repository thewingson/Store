package kz.almat.controller;

import kz.almat.model.Order;
import kz.almat.model.Product;
import kz.almat.model.User;
import kz.almat.service.OrderService;
import kz.almat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    private ModelAndView getList(User currentUser){

        List<Order> orders = orderService.getAll(currentUser);

        ModelAndView map = new ModelAndView("order/orders");
        map.addObject("orders", orders);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(Authentication authentication){
        User currentUser = (User) authentication.getCredentials();

        return getList(currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView getProducts(@PathVariable("id") Long id,
                                    Authentication authentication){
        User currentUser = (User) authentication.getCredentials();

        Order order = orderService.getById(id, currentUser);

        ModelAndView map = new ModelAndView("order/order-products");
        map.addObject("order", order);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addToCart/{id}/{page}")
    public RedirectView addToCart(@PathVariable(value = "id") Long id,
                          @PathVariable(value = "page") String page,
                                  HttpSession session){
        Map<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
        Integer cartSize = (Integer)session.getAttribute("cartSize");
        if(cart.containsKey(id)){
            cart.put(id, cart.get(id) + 1);
        } else {
            cart.put(id, 1);
        }
        cartSize++;

        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cartSize);

        switch (page){
            case "cart":
                return new RedirectView("/orders/cart");
            case "products":
                return new RedirectView("/products");
            default:
                return new RedirectView("/products");
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "/removeFromCart/{id}/{page}")
    public RedirectView removeFromCart(@PathVariable(value = "id") Long id,
                                       @PathVariable(value = "page") String page,
                                  HttpSession session){
        Map<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
        Integer cartSize = (Integer)session.getAttribute("cartSize");
        if(cart.containsKey(id)){
            cart.put(id, cart.get(id) - 1);
            cartSize--;
        }

        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cartSize);

        switch (page){
            case "cart":
                return new RedirectView("/orders/cart");
            case "products":
                return new RedirectView("/products");
            default:
                return new RedirectView("/products");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart")
    public ModelAndView cart(HttpSession session){

        Map<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");

        Map<Product, Integer> products = productService.getCartItems(cart);

        ModelAndView map = new ModelAndView("order/cart");
        map.addObject("products", products);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/purchase")
    public ModelAndView purchase(HttpSession session,
                                 Authentication authentication){
        User currentUser = (User) authentication.getCredentials();

        Map<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("cart");
        orderService.add(cart, currentUser);
        session.setAttribute("cart", new HashMap<Long, Integer>());

        return getList(currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id,
                               Authentication authentication){
        User currentUser = (User) authentication.getCredentials();
        BindingResult bindingResult = new MapBindingResult(new HashMap<String, Object>(), "order");

        Order order = orderService.getByIdWithProduct(id, currentUser);
        orderService.delete(order, bindingResult, currentUser);

        return getList(currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/approve/{id}")
    public ModelAndView approve(@PathVariable("id") Long id,
                                Authentication authentication){
        User currentUser = (User) authentication.getCredentials();
        orderService.approve(id, currentUser);
        return getList(currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delivered/{id}")
    public ModelAndView delivered(@PathVariable("id") Long id,
                                  Authentication authentication){
        User currentUser = (User) authentication.getCredentials();
        orderService.delivered(id, currentUser);
        return getList(currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{oid}/items/{iid}")
    public ModelAndView removeItem(@PathVariable("oid") Long orderId,
                                   @PathVariable("iid") Long itemId,
                                   Authentication authentication){
        User currentUser = (User) authentication.getCredentials();
        orderService.removeItem(orderId, itemId, currentUser);

        return getProducts(orderId, (Authentication) currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{oid}/items/{iid}/increase")
    public ModelAndView increase(@PathVariable("oid") Long orderId,
                                   @PathVariable("iid") Long itemId,
                                 Authentication authentication){
        User currentUser = (User) authentication.getCredentials();
        orderService.increase(orderId, itemId, currentUser);

        return getProducts(orderId, (Authentication) currentUser);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{oid}/items/{iid}/decrease")
    public ModelAndView decrease(@PathVariable("oid") Long orderId,
                                   @PathVariable("iid") Long itemId,
                                 Authentication authentication){
        User currentUser = (User) authentication.getCredentials();
        orderService.decrease(orderId, itemId, currentUser);

        return getProducts(orderId, (Authentication) currentUser);
    }

}
