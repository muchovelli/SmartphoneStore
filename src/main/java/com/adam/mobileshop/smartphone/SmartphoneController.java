package com.adam.mobileshop.smartphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;



    @GetMapping("/smartphoneList")
    public String viewListOfSmartphones(Model model){
        model.addAttribute("smartphoneList", smartphoneService.getSmartphones());
        return "smartphoneList";
    }

    @PostMapping("/saveSmartphone")
    public String saveSmartphone(@ModelAttribute("smartphone")Smartphone smartphone){
        //save employee to db
        smartphoneService.saveSmartphone(smartphone);
        return "redirect:/";
    }

    @GetMapping("/newScrapedSmartphone")
    public String showNewEmployeeForm(Model model){
        Smartphone smartphone = new Smartphone();
        model.addAttribute("smartphone",smartphone);
        return "scrapeSmartphone";
    }
    @PostMapping("/setNewScraping")
    public String setNewScraping(Model model, @RequestParam String link){
        //scrape
        Smartphone temp = new Smartphone();
        System.out.println(link + " dupa");
        temp = smartphoneService.scrapeSmartphone(link);
        temp.toString();
        //saveSmartphone
        smartphoneService.saveSmartphone(temp);
        smartphoneService.findById(1L);
        System.out.println("List: " + smartphoneService.getSmartphones());
        return "redirect:/";
    }


}
