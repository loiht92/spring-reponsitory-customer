package com.codegym.cms.test;

import com.codegym.cms.test.model.Province;
import com.codegym.cms.test.service.ProvinceService;

import java.util.Optional;

public class ProvinceServiceImplWithSpringData implements ProvinceService {
    @Override
    public Iterable<Province> findAll() {
        return null;
    }

    @Override
    public Optional<Province> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Province province) {

    }

    @Override
    public void delete(Long id) {

    }
}
