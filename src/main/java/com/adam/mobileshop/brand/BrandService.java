package com.adam.mobileshop.brand;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BrandService {
    Set<Brand> getBrands();
    Brand findById(long id);
    void deleteById(long id);
    void saveNewBrand(Brand brand);
}
