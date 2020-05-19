package com.codegym.cms.test.service;

import com.codegym.cms.test.model.Province;

import java.util.Optional;

public interface ProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void delete(Long id);
}
