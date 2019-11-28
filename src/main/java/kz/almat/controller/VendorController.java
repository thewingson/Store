package kz.almat.controller;

import kz.almat.model.Vendor;
import kz.almat.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    private ModelAndView getList(){

        List<Vendor> vendors = vendorService.getAll();

        ModelAndView map = new ModelAndView("vendor/vendors");
        map.addObject("vendors", vendors);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(){
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ModelAndView getById(@PathVariable("id") Long id){

        Vendor vendor= vendorService.getById(id);

        ModelAndView map = new ModelAndView("vendor/vendor");
        map.addObject("vendor", vendor);

        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public ModelAndView create(){
        ModelAndView map = new ModelAndView("vendor/create");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("vendor") Vendor vendor){
        vendorService.add(vendor);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        Vendor vendor= vendorService.getById(id);
        vendorService.delete(vendor);
        return getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id){

        Vendor vendor = vendorService.getById(id);
        ModelAndView map = new ModelAndView("vendor/edit");
        map.addObject("vendor", vendor);

        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ModelAndView update(@ModelAttribute("vendor") Vendor vendor){
        vendorService.edit(vendor);
        return getList();
    }
}
