package com.codegym.cms.service;

import com.codegym.cms.model.Province;
import com.codegym.cms.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
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
