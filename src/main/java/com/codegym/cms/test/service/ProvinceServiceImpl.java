package com.codegym.cms.test.service;

import com.codegym.cms.test.model.Province;
import com.codegym.cms.test.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        provinceRepository.deleteById(id);

    }
}
