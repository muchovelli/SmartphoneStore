package com.adam.mobileshop.smartphone;

import org.springframework.stereotype.Service;

import java.util.Set;

public interface SmartphoneService {
    Set<Smartphone> getSmartphones();
    Smartphone saveSmartphone(Smartphone smartphone);
    void deleteSmarthoneById(Long id);
    Smartphone findById(Long id);
    Smartphone scrapeSmartphone(String link);
    Long getIdFromLink(String link);
    Set<Smartphone> getResultList(String keyword);
    boolean validateLink(String link);
}
