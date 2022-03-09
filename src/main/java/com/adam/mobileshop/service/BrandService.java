package com.adam.mobileshop.service;

import com.adam.mobileshop.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> getBrands();
    Brand findById(long id);
    void deleteById(long id);
    void saveNewBrand(Brand brand);
}
