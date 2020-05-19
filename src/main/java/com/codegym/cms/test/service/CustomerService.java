package com.codegym.cms.test.service;
import com.codegym.cms.test.model.Customer;
import com.codegym.cms.test.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    //Iterable<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstName(String firstName, Pageable pageable);

    //Page<Customer> findAllCustomerSortByFirstName(Sort sort);

    Iterable<Customer> findAllByProvince(Province province);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
