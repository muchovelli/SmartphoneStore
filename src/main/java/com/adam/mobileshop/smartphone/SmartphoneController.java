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
        if(smartphone!=null){
            smartphoneService.saveSmartphone(smartphone);
        }else{

        }
        return "redirect:/";
    }

    @GetMapping("/newScrapedSmartphone")
    public String showNewEmployeeForm(Model model){
        Smartphone smartphone = new Smartphone();
        model.addAttribute("smartphone",smartphone);
        return "scrapeSmartphone";
    }
    @PostMapping("/setNewScraping")
    public String setNewScraping(@RequestParam String link){
        //scrape
        Smartphone temp = new Smartphone();
        temp = smartphoneService.scrapeSmartphone(link);
        temp.toString();
        //saveSmartphone
        smartphoneService.saveSmartphone(temp);
        return "redirect:/";
    }

    @GetMapping("/smartphone/{id}")
    public String viewSmartphoneInfo(@PathVariable(value = "id") long id, Model model){
        Smartphone smartphone = smartphoneService.findById(id);
        model.addAttribute("smartphone", smartphone);
        return "smartphone";
    }

    @GetMapping("/deleteSmartphone/{id}")
    public String deleteSmartphone(@PathVariable(value = "id") long id){
        this.smartphoneService.deleteSmarthoneById(id);
        return "redirect:/";
    }

    @PostMapping("/newCompareSmartphones")
    public String newCompareSmartphones(@RequestParam String link1, @RequestParam String link2){
        Long id1 = smartphoneService.getIdFromLink(link1);
        Long id2 = smartphoneService.getIdFromLink(link2);
        return "redirect:/compareModels/" + id1 + "vs" + id2;
    }

    @GetMapping("compareModels/{id1}vs{id2}")
    public String compareModels(@PathVariable(value = "id1") Long id1, @PathVariable(value = "id2") Long id2, Model model1, Model model2){
        Smartphone smartphone1 = smartphoneService.findById(id1);
        model1.addAttribute("smartphone1", smartphone1);
        Smartphone smartphone2 = smartphoneService.findById(id2);
        model2.addAttribute("smartphone2", smartphone2);
        return "compareModels";
    }
    @GetMapping("compareModels")
    public String compareModels(Model model1, Model model2){
        Smartphone smartphone1 = new Smartphone();
        smartphone1.setId(0L);
        model1.addAttribute("smartphone1", smartphone1);
        Smartphone smartphone2 = new Smartphone();
        smartphone2.setId(0L);
        model2.addAttribute("smartphone2", smartphone2);
        return "compareModels";
    }

    @PostMapping("/getKeyword")
    public String getKeyword(@RequestParam String keyword){
        return "redirect:/resultlist/" + keyword;
    }

    @GetMapping("/resultlist/{keyword}")
    public String getResultList(Model model,@PathVariable(value = "keyword") String keyword){
        model.addAttribute("smartphoneList", smartphoneService.getResultList(keyword));
        return "resultlist";
    }
}
