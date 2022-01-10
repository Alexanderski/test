package com.example.demo.controller;


import com.example.demo.dto.ModelDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {
   private StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/get-all-stores")
    public String getAllStores(Model model) {
        model.addAttribute("stores", storeService.getAllStores());
        return "stores";
    }
   /*@GetMapping("/get-mark-with-stores")
    public String getMarkWithModelsByMarkId(Model map, @RequestParam int id){
        map.addAttribute("mark", storeService.getMarkWithStoresByMarkId(id));
        return "stores";
    }*/
    @GetMapping("/update-store")
    public String updateStoreForm(@RequestParam int id, Model model ){
        model.addAttribute("store", storeService.getStoreById(id));
        return "saveNewStore";
    }

    @GetMapping("/add-new-store")
    public String addNewStoreForm(Model model){
        model.addAttribute("store", new StoreDto());
        return "saveNewStore";
    }

    @PostMapping("/save-store")
    public String saveNewStore(@ModelAttribute("store") StoreDto storeDto){
        storeService.saveOrUpdate(storeDto);
        return "redirect:/get-all-marks";

    }
    @GetMapping("/delete-store")
    public String deleteStore(@RequestParam int id){
        storeService.deleteStore(id);
        return "redirect:/get-all-marks";
    }
}
