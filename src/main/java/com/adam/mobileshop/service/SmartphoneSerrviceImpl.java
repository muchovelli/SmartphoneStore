package com.adam.mobileshop.service;

import com.adam.mobileshop.model.Smartphone;
import com.adam.mobileshop.repository.SmartphoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneSerrviceImpl implements SmartphoneService{
    @Autowired
    private SmartphoneRepo smartphoneRepo;

    @Override
    public List<Smartphone> getSmartphones() {
        return smartphoneRepo.findAll();
    }

    @Override
    public void newSmartphone(Smartphone smartphone) {

    }

    @Override
    public void deleteSmarthoneById(long id) {

    }

    @Override
    public Smartphone findById(long id) {
        return null;
    }
}
