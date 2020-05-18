package com.codegym.cms.controller;

import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "customer/user";
    }

    @GetMapping("/admin")
    public String admin(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "customer/admin";
    }

    @GetMapping("/accessDenied")
    public String error() {
        return "accessDenied";
    }
}

