package com.adam.mobileshop.smartphone;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SmartphoneService {
    List<Smartphone> getSmartphones();
    Smartphone saveSmartphone(Smartphone smartphone);
    void deleteSmarthoneById(long id);
    Smartphone findById(long id);
    Smartphone scrapeSmartphone(String link);
}
