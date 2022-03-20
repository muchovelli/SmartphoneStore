package com.adam.mobileshop.smartphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    /*@GetMapping("/")
    public String viewIndex(Model model){
        model.getAttribute("listOfSmarthone", smartphoneService.getSmartphones());
        return "index";
    }*/

    @PostMapping("/saveSmartphone")
    public String saveSmartphone(@ModelAttribute("smartphone")Smartphone smartphone){
        //save employee to db
        smartphoneService.saveSmartphone(smartphone);
        return "redirect:/";
    }
    @PostMapping("/scrapeSmartphone")
    public String scrapeSmartphone(@ModelAttribute("link")String link){
        //save employee to db
        Smartphone temp = new Smartphone();
        temp = smartphoneService.scrapeSmartphone(link);
        smartphoneService.saveSmartphone(temp);
        return "redirect:/";
    }

}
