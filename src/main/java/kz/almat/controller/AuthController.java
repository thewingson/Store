package kz.almat.controller;

import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = {"", "/signIn"})
    public ModelAndView signIn(){

        ModelAndView map = new ModelAndView("auth/sign-in");

        return map;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/signIn")
//    public ModelAndView signInDo(@ModelAttribute("user") User user){
//
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/signUp")
    public ModelAndView signUp(){

        ModelAndView map = new ModelAndView("auth/sign-up");

        return map;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
//    public ModelAndView signUpDo(@ModelAttribute("user") User user){
//
//    }

}
