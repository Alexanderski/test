package com.example.demo.controller;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import com.example.demo.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelController  {
    private ModelService modelService;
    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }
    @GetMapping("/get-mark-with-models")
    public String getMarkWithModelsByMarkId(Model map, @RequestParam int id){
        map.addAttribute("mark",modelService.getMarkWithModelsByMarkId(id));
        return "models";
    }
    @GetMapping("/update-model")
    public String updateMarkForm(@RequestParam int id, Model model ){
        model.addAttribute("model", modelService.getModelById(id));
        return "saveNewModel";
    }

    @GetMapping("/add-new-model")
    public String addNewMarkForm(Model model){
        model.addAttribute("model", new ModelDto());
        return "saveNewModel";
    }

    @PostMapping("/save-model")
    public String saveNewModel(@ModelAttribute("model") ModelDto modelDto){
        modelService.saveOrUpdate(modelDto);
        return "redirect:/get-all-marks";

    }
    @GetMapping("/delete-model")
    public String deleteModel(@RequestParam int id){
        modelService.deleteModel(id);
        return "redirect:/get-all-marks";
    }
}
