package com.codegym.cms.test.controller;

import com.codegym.cms.test.model.Province;
import com.codegym.cms.test.service.CustomerService;
import com.codegym.cms.test.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public ModelAndView listProvince() {
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateProvinceForm(){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createProvince(@ModelAttribute("province") Province province, RedirectAttributes redirect){
        provinceService.save(province);
        redirect.addFlashAttribute("message", "create province successfully !");
        return "redirect:/province";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEditProvince(@PathVariable long id){
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        }else {
            return new ModelAndView("/province/error");
        }
    }

    @PostMapping("/edit")
    public String updateProvince(@ModelAttribute("province") Province province, RedirectAttributes redirect){
        provinceService.save(province);
        redirect.addFlashAttribute("message","edit province successfully !");
        return "redirect:/province";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDeleteProvince(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("province/error");
        }
    }

    @PostMapping("/delete")
    public String deleteProvince(@ModelAttribute("province") Province province, RedirectAttributes redirect){
        provinceService.delete(province.getId());
        redirect.addFlashAttribute("message", "delete province successfully !");
        return "redirect:/province";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProvince(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("province/view");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("/province/error");
        }
    }
}
















