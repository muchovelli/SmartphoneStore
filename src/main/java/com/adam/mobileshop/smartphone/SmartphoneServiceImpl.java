package com.adam.mobileshop.smartphone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    private SmartphoneRepo smartphoneRepo;


    protected Map<Long, Smartphone> map = new HashMap<>();

    @Override
    public Set<Smartphone> getSmartphones() {
        Set<Smartphone> smartphones = new HashSet<>();
        smartphoneRepo.findAll().forEach(smartphones::add);
        return smartphones;
    }

    @Override
    public Smartphone saveSmartphone(Smartphone smartphone) {
        if (smartphone != null) {
            System.out.println("duap");
            for (Smartphone smartphone1 : smartphoneRepo.findAll()) {
                if (smartphone1.getLink() != null) {
                    if (smartphone1.getLink().equals(smartphone.getLink())) {
                        System.out.println("Already in database!");
                        return null;
                    }
                }
            }
            System.out.println("duapsssssssssssssssssssss");

            map.put(smartphone.getId(), smartphone);
            this.smartphoneRepo.save(smartphone);
            return smartphone;
        } else {
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
        if (optional.isPresent()) {
            smartphone = optional.get();
        } else {
            throw new RuntimeException("Blad");
        }
        return smartphone;
    }


    @Override
    public Smartphone scrapeSmartphone(String link) {
        Smartphone smartphone = new Smartphone();
        try {
            smartphone.setLink(link);
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
            if (document.select("tr:nth-of-type(26) > .phoneCategoryValue").attr("class").equals("tick")) {
                smartphone.setDualSim(true);
            } else {
                smartphone.setDualSim(false);
            }
            System.out.println("DS: " + smartphone.getDualSim());


            //Bluetooth
            if (document.select("li:nth-of-type(12) > .phoneCategoryValue").attr("class").equals("tick")) {
                smartphone.setBluetooth(true);
            } else {
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

    @Override
    public Long getIdFromLink(String link1) {
        for (Smartphone smartphone : smartphoneRepo.findAll()) {
            if (smartphone.getLink().equals(link1)) {
                return smartphone.getId();
            }
        }
        return null;
    }

    @Override
    public Set<Smartphone> getResultList(String keyword) {
        Set<Smartphone> resultSet = new HashSet<>();
        String lowerCaseKeyword = keyword.toLowerCase(Locale.ROOT);
        for (Smartphone smartphone : smartphoneRepo.findAll()) {
            if (smartphone.getModelName().toLowerCase(Locale.ROOT).contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            } else if (smartphone.getLink().toLowerCase(Locale.ROOT).contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            } else if (smartphone.getOperatingSystem().toLowerCase(Locale.ROOT).contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            } else if (smartphone.getInternalMemory().contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            } else if (smartphone.getOtherNames().contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            } else if (smartphone.getDisplay().toLowerCase(Locale.ROOT).contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            } else if (smartphone.getStandards().contains(lowerCaseKeyword)) {
                resultSet.add(smartphone);
            }
        }
        return resultSet;
    }

    @Override
    public boolean validateLink(String link) {
        if (link.contains("gsmchoice.com/en/catalogue/")) {
            return true;
        }
        return false;
    }
}
