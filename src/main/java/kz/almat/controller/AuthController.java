package kz.almat.controller;

import kz.almat.model.User;
import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = {"", "/signIn"})
    public ModelAndView signIn(@RequestParam(value = "message", required = false) String message){

        ModelAndView map = new ModelAndView("auth/sign-in");

        if(message != null){
            map.addObject("message", message);
        }

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signUp")
    public ModelAndView signUp(){

        ModelAndView map = new ModelAndView("auth/sign-up");

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public RedirectView signUp(@ModelAttribute("user") User user,
                                 @RequestParam("confirmPassword") String confirmPassword){
        if(user.getPassword().equals(confirmPassword)){
            userService.add(user);
        }

        RedirectView redirectView = new RedirectView("/login");
        redirectView.addStaticAttribute("username", user.getUsername());
        redirectView.addStaticAttribute("password", user.getPassword());
        return redirectView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/saveSession")
    public RedirectView saveSession(HttpSession httpSession){

        httpSession.setAttribute("username", "active");

        return new RedirectView("/products");
    }

}
