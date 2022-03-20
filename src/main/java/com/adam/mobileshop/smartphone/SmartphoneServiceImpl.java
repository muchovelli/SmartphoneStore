package com.adam.mobileshop.smartphone;

import com.adam.mobileshop.brand.Brand;
import com.adam.mobileshop.brand.BrandRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneServiceImpl implements SmartphoneService{
    @Autowired
    private SmartphoneRepo smartphoneRepo;
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public List<Smartphone> getSmartphones() {
        return smartphoneRepo.findAll();
    }

    @Override
    public Smartphone saveSmartphone(Smartphone smartphone) {
        smartphoneRepo.save(smartphone);
        return smartphone;
    }

    @Override
    public void deleteSmarthoneById(long id) {
        smartphoneRepo.deleteById(id);
    }

    @Override
    public Smartphone findById(long id) {
        Optional<Smartphone> optional = smartphoneRepo.findById(id);
        Smartphone smartphone = null;
        if(optional.isPresent()){
            smartphone = optional.get();
        }else{
            throw new RuntimeException("Blad");
        }
        return smartphone;
    }

    @Override
    public Smartphone scrapeSmartphone(String link) {
        Smartphone smartphone = new Smartphone();
        Brand brand = new Brand();
        try {
            final Document document = Jsoup.connect(link).get();
            //Brand
            brand.setName(document.select("tr:nth-of-type(1) > .phoneCategoryValue").text());
            brandRepo.save(brand);
            //smartphone.setBrand(brand);

            //ModelName
            smartphone.setModelName(document.select("tr:nth-of-type(2) > .phoneCategoryValue").text());

            //Other names
            smartphone.setOtherNames(Collections.singletonList(""));

            //Standards
            String str = document.select("tr:nth-of-type(4) > .phoneCategoryValue").text();
            String[] strgs = str.split(" ");
            smartphone.setStandards(List.of(strgs));


            //Operating System
            smartphone.setOperatingSystem(document.select("tr:nth-of-type(23) > .phoneCategoryValue").text());

            //Dual Sim
            if(document.select("tr:nth-of-type(26) > .phoneCategoryValue").attr("class").equals("tick")) {
                smartphone.setDualSim(true);
            }else{
                smartphone.setDualSim(false);
            }

            //Bluetooth
            if(document.select("li:nth-of-type(12) > .phoneCategoryValue").attr("class").equals("tick")) {
                smartphone.setBluetooth(true);
            }else{
                smartphone.setBluetooth(false);
            }

            //Camera
           // smartphone.setCamera();

            //Quantity
            smartphone.setQuantity(1);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return smartphone;
    }
}
