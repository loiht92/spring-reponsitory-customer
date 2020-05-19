package cg.test;

import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.CustomerServiceImpl;
import com.codegym.cms.service.ProvinceService;
import com.codegym.cms.service.ProvinceServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cg.test")
@EnableSpringDataWebSupport
public class CustomerControllerTestConfig {
    @Bean
    public CustomerService customerService(){
        return Mockito.mock(CustomerServiceImpl.class);
    }

    @Bean
    public ProvinceService provinceService() {
        return Mockito.mock(ProvinceServiceImpl.class);
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("cms")
                .build();
    }

}
