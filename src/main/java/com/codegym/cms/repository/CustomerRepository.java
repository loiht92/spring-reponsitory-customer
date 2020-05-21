package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstName(String firstName , Pageable pageable);

    //Page<Customer> findAll(Pageable pageable, Sort sort);

    //List<Customer> findAllByFirstNameOrderByFirstNameDesc(Sort sort);


}
