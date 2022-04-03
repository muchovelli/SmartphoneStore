package com.adam.mobileshop.smartphone;

import com.adam.mobileshop.brand.BrandRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SmartphoneServiceImpl implements SmartphoneService{
    @Autowired
    private SmartphoneRepo smartphoneRepo;


    protected Map<Long, Smartphone> map = new HashMap<>();

    @Override
    public Set<Smartphone> getSmartphones() {
        System.out.println(map);
        return new HashSet<>(map.values());
    }

    @Override
    public Smartphone saveSmartphone(Smartphone smartphone) {
        if(smartphone!=null){
            map.put(smartphone.getId(),smartphone);

            this.smartphoneRepo.save(smartphone);
            return smartphone;
        }else{
            return null;
        }
    }

    @Override
    public void deleteSmarthoneById(Long id) {
        smartphoneRepo.deleteById(id);
    }

    @Override
    public Smartphone findById(Long id) {
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
        try {
            final Document document = Jsoup.connect(link).get();
            //ModelName
            smartphone.setModelName(document.select("tr:nth-of-type(2) > .phoneCategoryValue").text());
            System.out.println("Model name: " + smartphone.getModelName());

            //Other names
            smartphone.setOtherNames(Collections.singletonList(""));
            System.out.println("Other names: " + smartphone.getOtherNames());


            //Standards
            String str = document.select("tr:nth-of-type(4) > .phoneCategoryValue").text();
            String[] strgs = str.split(" ");
            smartphone.setStandards(List.of(strgs));
            System.out.println("Standards: " + smartphone.getStandards());


            //Weight
            //smartphone.setWeight(document.select("tr:nth-of-type(13) > .phoneCategoryValue").text());
            smartphone.setWeight(110f);
            System.out.println("Weight: " + smartphone.getWeight());


            //Display
            smartphone.setDisplay(document.select("tr:nth-of-type(14) > .phoneCategoryValue").text());
            System.out.println("Display: " + smartphone.getDisplay());


            //Internal Memory
            String initialMemory = document.select("tr:nth-of-type(22) > .phoneCategoryValue").text();
            String[] initialMemories = str.split(", ");
            smartphone.setInternalMemory(List.of(initialMemories));
            System.out.println("Internal: " + smartphone.getInternalMemory());


            //Operating System
            smartphone.setOperatingSystem(document.select("tr:nth-of-type(23) > .phoneCategoryValue").text());
            System.out.println("Operating System: " + smartphone.getOperatingSystem());


            //Dual Sim
            if(document.select("tr:nth-of-type(26) > .phoneCategoryValue").attr("class").equals("tick")) {
                smartphone.setDualSim(true);
            }else{
                smartphone.setDualSim(false);
            }
            System.out.println("DS: " + smartphone.getDualSim());


            //Bluetooth
            if(document.select("li:nth-of-type(12) > .phoneCategoryValue").attr("class").equals("tick")) {
                smartphone.setBluetooth(true);
            }else{
                smartphone.setBluetooth(false);
            }
            System.out.println("Bth " + smartphone.getBluetooth());


            //Camera
           // smartphone.setCamera();

            //Quantity
            smartphone.setQuantity(1);
            System.out.println("Model name: " + document.select("tr:nth-of-type(2) > .phoneCategoryValue").text());
            return smartphone;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
