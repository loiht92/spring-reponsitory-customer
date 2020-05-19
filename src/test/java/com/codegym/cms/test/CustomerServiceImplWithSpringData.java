package com.codegym.cms.test;

import com.codegym.cms.test.model.Customer;
import com.codegym.cms.test.model.Province;
import com.codegym.cms.test.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CustomerServiceImplWithSpringData implements CustomerService {
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Customer> findAllByFirstName(String firstName, Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(Long id) {

    }
}
