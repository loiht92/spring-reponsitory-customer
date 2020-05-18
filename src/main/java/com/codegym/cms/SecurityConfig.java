package com.codegym.cms;

import com.codegym.cms.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService appUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/**").authenticated()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/user/**").access("hasRole('USER')")
                //.antMatchers("/articles/**").access("hasAnyRole('ADMIN','USER')")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling()
                // .accessDeniedHandler(new MyAccessDeniedHandler())
                .accessDeniedPage("/accessDenied")

        ;
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/list/**").access("hasRole('ADMIN')")
//                .antMatchers("/user/**").access("hasRole('USER')")
//
//                .and()
//                .authorizeRequests()
////                .antMatchers("/user").hasRole("USER")
////                .and()
////                .authorizeRequests()
////                .antMatchers("/admin/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                //.loginProcessingUrl("/customer")
//                //.loginPage("/**/customer")
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("user").password("12345").roles("USER")
//            .and()
//            .withUser("admin").password("12345").roles("ADMIN");

        auth.userDetailsService((UserDetailsService) appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
}
