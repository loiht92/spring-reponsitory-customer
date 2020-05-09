package com.codegym.cms.service;
import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    //Iterable<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    //List<Customer> findAllFirstName(Sort sort);

    Page<Customer> findAllByFirstName(String firstName, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
