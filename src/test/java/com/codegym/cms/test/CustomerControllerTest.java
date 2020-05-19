package com.codegym.cms.test;


import com.codegym.cms.test.controller.CustomerController;
import com.codegym.cms.test.model.Customer;
import com.codegym.cms.test.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringJUnitJupiterConfig(CustomerControllerTestConfig.class)
public class CustomerControllerTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @InjectMocks //Dùng để tiêm dịch vụ giả định vào trong controller.
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.ctx);
        this.mockMvc = builder.build();
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(customerController)
//                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
//                .build();
    }

//    @Test
//    public void testUserController () throws Exception {
//        ResultMatcher ok = MockMvcResultMatchers.status()
//                .isOk();
//
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/customer");
//        this.mockMvc.perform(builder)
//                .andExpect(ok);
//
//    }

    //Kiem thu Controller - list.
    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexJSPViewName() throws Exception {
        mockMvc
                .perform(get("/customer")) //Giả lập gửi 1 request tới url chỉ định
                .andDo(print()) //Giúp in request và response tới luồng out
                .andExpect(view().name("customer/list")); // Xác nhận view.
    }

    //Kiểm thử controller - update.
    @Test
    void customerUpdateSuccessControlling() throws Exception {
        Customer customer = new Customer(14L, "Hồ", "Lợi");
        customerService.save(customer);
        mockMvc
                .perform(post("/customer/edit")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", customer.getId().toString())
                        .param("firstName", customer.getFirstName())
                        .param("lastName", customer.getLastName()))
                //.andExpect(status().isFound())
                .andExpect(redirectedUrl("/customer"));
    }

    @Test
    void customersListPageIsExists() throws Exception {
        mockMvc
                .perform(get("/customer"))
                .andExpect(status().isOk());
    }

    @Test
    void customerBrowseControlling() throws Exception {
        mockMvc
                .perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/list"));
    }

}

