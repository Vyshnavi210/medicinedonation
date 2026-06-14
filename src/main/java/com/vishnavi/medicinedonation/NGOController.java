package com.vishnavi.medicinedonation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NGOController {

    @Autowired
    private NGORepository ngoRepository;

    @GetMapping("/ngo/register")
    public String showRegister(Model model) {

        model.addAttribute("ngo", new NGO());

        return "ngo-register";
    }

    @PostMapping("/ngo/register")
    public String register(@ModelAttribute NGO ngo) {

        ngo.setStatus("ACTIVE");

        ngoRepository.save(ngo);

        return "ngo-success";
    }
}