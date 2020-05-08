package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    //pre-processing
   @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
       return provinceService.findAll();
   }

   @GetMapping
    public ModelAndView listCustomer(Pageable pageable) {
      Page<Customer> customers = customerService.findAll(pageable);
      ModelAndView modelAndView = new ModelAndView("customer/list");
      modelAndView.addObject("customers", customers);
      return modelAndView;
   }

   @GetMapping("/create")
    public ModelAndView showCreateCustomer(){
       ModelAndView modelAndView = new ModelAndView("customer/create");
       modelAndView.addObject("customer", new Customer());
       return modelAndView;
   }

   @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
       byte[] byte1 =  customer.getFirstName().getBytes(StandardCharsets.ISO_8859_1);
       byte[] byte2 =  customer.getLastName().getBytes(StandardCharsets.ISO_8859_1);
       String decodedSignature1 = new String(byte1, StandardCharsets.UTF_8);
       String decodedSignature2 = new String(byte2, StandardCharsets.UTF_8);
       customer.setFirstName(decodedSignature1);
       customer.setLastName(decodedSignature2);

       customerService.save(customer);
       redirect.addFlashAttribute("message", "create customer successfully !");
       return "redirect:/customer";
   }

   @GetMapping("/edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable Long id){
       Optional<Customer> customer = customerService.findById(id);
       if (customer.isPresent()){
           ModelAndView modelAndView = new ModelAndView("/customer/edit");
           modelAndView.addObject("customer", customer.get());
           return modelAndView;
       } else {
           return new ModelAndView("/customer/error");
       }
   }

   @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
       byte[] byte1 =  customer.getFirstName().getBytes(StandardCharsets.ISO_8859_1);
       byte[] byte2 =  customer.getLastName().getBytes(StandardCharsets.ISO_8859_1);
       String decodedSignature1 = new String(byte1, StandardCharsets.UTF_8);
       String decodedSignature2 = new String(byte2, StandardCharsets.UTF_8);
       customer.setFirstName(decodedSignature1);
       customer.setLastName(decodedSignature2);

       customerService.save(customer);
       redirect.addFlashAttribute("message","edit customer successfully !");
       return "redirect:/customer";
   }

   @GetMapping("/delete/{id}")
    public ModelAndView showDeleteCustomer(@PathVariable Long id) {
       Optional<Customer> customer = customerService.findById(id);
       //customer.getName()?
       //customer.firstName?
       if (customer.isPresent()){
           ModelAndView modelAndView = new ModelAndView("/customer/delete");
           modelAndView.addObject("customer", customer.get());
           return modelAndView;
       } else {
           return new ModelAndView("/customer/error");
       }
   }
    //delete
   @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
       customerService.remove(customer.getId());
       redirect.addFlashAttribute("message", "delete customer successfully !");
       return "redirect:/customer";
   }

   @GetMapping("/view/{id}")
    public ModelAndView viewCustomer(@PathVariable Long id){
       Optional<Customer> customer = customerService.findById(id);
       if (customer.isPresent()){
           ModelAndView modelAndView = new ModelAndView("/customer/view");
           modelAndView.addObject("customer", customer.get());
           return modelAndView;
       }
       else {
           return new ModelAndView("/customer/error");
       }
   }
}
