package com.example.demo.controller;

import com.example.demo.dto.MarkDto;
import com.example.demo.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarkController {

    private MarkService markService;

    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/get-all-marks")
    public String getAllMarks(Model model){
        model.addAttribute("marks",markService.getAllMarks());
        return "marks";
    }
    @GetMapping("/get-mark")
    public void getMarkById(@RequestParam int id){
        System.out.println(markService.getMarkById(id));
    }

    @GetMapping("/update-mark")
    public String updateMarkForm(@RequestParam int id, Model model ){
        model.addAttribute("mark", markService.getMarkById(id));
        return "saveNewMark";
    }

    @GetMapping("/add-new-mark")
    public String addNewMarkForm(Model model){
        model.addAttribute("mark", new MarkDto());
        return "saveNewMark";
    }

    @PostMapping("/save-mark")
    public String saveNewMark(@ModelAttribute("mark") MarkDto markDto){
        markService.saveOrUpdate(markDto);
        return "redirect:/get-all-marks";

    }
    @GetMapping("/delete")
    public String deleteMark(@RequestParam int id){
        markService.deleteMark(id);
        return "redirect:/get-all-marks";
    }
}
