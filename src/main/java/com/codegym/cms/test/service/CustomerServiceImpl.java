package com.codegym.cms.test.service;

import com.codegym.cms.test.model.Customer;
import com.codegym.cms.test.model.Province;
import com.codegym.cms.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


//    @Override
//    public List<Customer> findAllByOrderByFirstNameDesc(Sort sort) {
//        return (List<Customer>) customerRepository.findAllByFirstNameOrderByFirstNameDesc(Sort.by("firstName").descending());
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
//
//    @Override
//    public Page<Customer> findAll(Sort sort) {
//        return (Page<Customer>) customerRepository.findAll(sort);
//    }

    @Override
    public Page<Customer> findAllByFirstName(String firstName, Pageable pageable) {
        return customerRepository.findAllByFirstName(firstName , pageable);
    }

//    @Override
//    public Page<Customer> findAllCustomerSortByFirstName(Sort sort) {
//        return (Page<Customer>) customerRepository.findAll(sort);
//    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);

    }
}
