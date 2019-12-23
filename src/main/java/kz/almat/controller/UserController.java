package kz.almat.controller;

import kz.almat.model.User;
import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    private ModelAndView getList(){

        List<User> users = userService.getAll();

        ModelAndView map = new ModelAndView("user/users");
        map.addObject("users", users);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(){
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView getById(@PathVariable("id") Long id){

        User user = userService.getById(id);

        ModelAndView map = new ModelAndView("profile");
        map.addObject("user", user);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id){
        User user= userService.getById(id);
        userService.delete(user);
        return new RedirectView("/admin/users");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id){

        User user = userService.getById(id);
        ModelAndView map = new ModelAndView("admin/users/edit");
        map.addObject("user", user);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
    public RedirectView update(@PathVariable("id") Long id,
                               @ModelAttribute("user") User user){
        user.setId(id);
        userService.edit(user);
        return new RedirectView("/admin/users");
    }

}
