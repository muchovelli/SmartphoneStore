package com.adam.mobileshop.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public Set<Brand> getBrands() {
        return (Set<Brand>) brandRepo.findAll();
    }

    @Override
    public Brand findById(long id) {
        Optional<Brand> optional = brandRepo.findById(id);
        Brand brand;
        if(optional.isPresent()){
            brand = optional.get();
        }else{
            throw new RuntimeException("Finding by id in BrandRepo error");
        }
        return brand;
    }

    @Override
    public void deleteById(long id) {
        brandRepo.deleteById(id);
    }

    @Override
    public void saveNewBrand(Brand brand) {
        brandRepo.save(brand);
    }
}
