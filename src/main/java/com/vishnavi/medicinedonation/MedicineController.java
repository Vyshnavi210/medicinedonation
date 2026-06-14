package com.vishnavi.medicinedonation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/medicine/donate")
    public String showDonatePage(Model model) {

        model.addAttribute("medicine", new Medicine());

        return "donate-medicine";
    }

    @PostMapping("/medicine/save")
    public String saveMedicine(@ModelAttribute Medicine medicine) {

        medicine.setStatus("PENDING");

        medicineRepository.save(medicine);

        return "medicine-success";
    }
}