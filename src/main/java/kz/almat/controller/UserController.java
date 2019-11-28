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

        ModelAndView map = new ModelAndView("user/user");
        map.addObject("user", user);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create(){
        ModelAndView map = new ModelAndView("user/create");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("user") User user){
        userService.add(user);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        User user= userService.getById(id);
        userService.delete(user);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id){

        User user = userService.getById(id);
        ModelAndView map = new ModelAndView("user/edit");
        map.addObject("user", user);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView update(@ModelAttribute("user") User user){
        userService.edit(user);
        return getList();
    }

}
