package kz.almat.controller;

import kz.almat.model.User;
import kz.almat.model.dto.UserDTO;
import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

//    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
//    public ModelAndView signUp(@ModelAttribute("user") @Valid UserDTO userDTO,
//                               BindingResult result, WebRequest request, Errors errors){
//        User registered = new User();
//        if (!result.hasErrors()) {
//            registered = userService.add(userDTO, result);
//        }
//        if (registered == null) {
//            result.rejectValue("email", "message.regError");
//        }
//        if (result.hasErrors()) {
//            return new ModelAndView("/auth/sign-up", "user", userDTO);
//        }
//        else {
//            return new ModelAndView("/auth/sign-in");
//        }
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public ModelAndView signUp(@ModelAttribute("user") @Valid UserDTO userDTO,
                               BindingResult result){

        ModelAndView map = new ModelAndView("auth/sign-up");

        User registered = new User();
        if (!result.hasErrors()) {
            registered = userService.add(userDTO, result);
        }
        if (registered == null) {
            map.addObject("message", "Email or Username is already in use");
        }
        if (result.hasErrors()) {
            map.addObject("user", userDTO);
            map.addObject("message", "Not valid inputs");
            return map;
        }
        else {
            return new ModelAndView("/auth/sign-in");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/saveSession")
    public RedirectView saveSession(HttpSession httpSession){

        httpSession.setAttribute("username", "active");

        return new RedirectView("/products");
    }

}
