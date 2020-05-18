package com.codegym.cms.controller;

import com.codegym.cms.model.AppUser;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;
    //
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

//    @PostMapping("/register")
//    public ModelAndView processRegister(@ModelAttribute("appUser")AppUser appUser){
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//
//        appUser.getUsername();
//        return (ModelAndView) authorities;
//    }
    //

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

