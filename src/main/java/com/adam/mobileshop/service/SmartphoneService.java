package com.adam.mobileshop.service;

import com.adam.mobileshop.model.Smartphone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SmartphoneService {
    List<Smartphone> getSmartphones();
    void newSmartphone(Smartphone smartphone);
    void deleteSmarthoneById(long id);
    Smartphone findById(long id);
}
