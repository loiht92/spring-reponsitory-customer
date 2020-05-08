package com.codegym.cms.service;
import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Iterator;
import java.util.Optional;

public interface CustomerService {
    //Iterable<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
