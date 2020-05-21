package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProvinceRepository extends CrudRepository<Province, Long> {
    @Query("SELECT p from Province p INNER JOIN Customer c ON p.id = c.province.id where c =: customer")
    Optional<Province> findByCustomer(@Param("customer") Customer customer);
}