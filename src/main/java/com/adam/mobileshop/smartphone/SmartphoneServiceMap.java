package com.adam.mobileshop.smartphone;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile({"default","map"})
public class SmartphoneServiceMap<Smartphone, Long> implements SmartphoneService{
    protected Map<com.adam.mobileshop.smartphone.Smartphone, java.lang.Long> map = new HashMap<>();
    @Override
    public List<com.adam.mobileshop.smartphone.Smartphone> getSmartphones() {
        return new ArrayList(map.values());
    }

    @Override
    public com.adam.mobileshop.smartphone.Smartphone saveSmartphone(com.adam.mobileshop.smartphone.Smartphone smartphone) {
        if(smartphone != null) {
            map.put(smartphone, smartphone.getId());
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return smartphone;
    }

    @Override
    public void deleteSmarthoneById(long id) {

    }

    @Override
    public com.adam.mobileshop.smartphone.Smartphone findById(long id) {
        return null;
    }

    @Override
    public com.adam.mobileshop.smartphone.Smartphone scrapeSmartphone(String link) {
        return null;
    }
}
