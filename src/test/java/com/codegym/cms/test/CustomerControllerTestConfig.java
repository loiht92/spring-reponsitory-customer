package com.codegym.cms.test;

import com.codegym.cms.test.repository.AppUserRepository;
import com.codegym.cms.test.repository.CustomerRepository;
import com.codegym.cms.test.service.AppUserService;
import com.codegym.cms.test.service.AppUserServiceImpl;
import com.codegym.cms.test.service.CustomerService;
import com.codegym.cms.test.service.ProvinceService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@ComponentScan("com.codegym.cms.test")
//@EnableSpringDataWebSupport
public class CustomerControllerTestConfig {
    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }
    @Bean
    public AppUserRepository appUserRepository() {
        return Mockito.mock(AppUserRepository.class);
    }
    @Bean
    public CustomerService customerService(){
        return Mockito.mock(CustomerServiceImplWithSpringData.class);
    }

    @Bean
    public ProvinceService provinceService() {
        return Mockito.mock(ProvinceServiceImplWithSpringData.class);
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("cms")
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AppUserService appUserService(){
        return new AppUserServiceImpl();
    }

}
