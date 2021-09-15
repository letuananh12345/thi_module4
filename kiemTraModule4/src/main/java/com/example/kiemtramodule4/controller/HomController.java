package com.example.kiemtramodule4.controller;

import com.example.kiemtramodule4.model.City;
import com.example.kiemtramodule4.model.Country;
import com.example.kiemtramodule4.service.IServiceCity;
import com.example.kiemtramodule4.service.IServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomController {
    @Autowired
    IServiceCountry iServiceCountry;
    @Autowired
    IServiceCity iServiceCity;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("listCity", iServiceCity.findAll());
        return modelAndView;
    }

    @ModelAttribute("countrysss")
    public ArrayList<Country> listCountry() {
        return (ArrayList<Country>) iServiceCountry.findAll();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", iServiceCity.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute City city,BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors())
        {
            ModelAndView modelAndView=new ModelAndView("edit") ;
            return modelAndView;
        }

        iServiceCity.save(city);
        return new ModelAndView("redirect:/show");
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());

        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors())
            {
              ModelAndView modelAndView=new ModelAndView("create") ;
              return modelAndView;
            }
        iServiceCity.save(city);
        return new ModelAndView("redirect:/show");

    }
    @GetMapping("/delete/{id}")
    public ModelAndView showCDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city", iServiceCity.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute City city) {



        iServiceCity.delete(city);
        return new ModelAndView("redirect:/show");

    }
    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("city", iServiceCity.findById(id));
        return modelAndView;
    }

}
