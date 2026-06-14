package com.vishnavi.medicinedonation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NGOLoginController {

    @Autowired
    private NGORepository ngoRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    private String loggedInNgoName;

    @GetMapping("/ngo/login")
    public String loginPage() {
        return "ngo-login";
    }

    @PostMapping("/ngo/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        NGO ngo =
                ngoRepository.findByEmailAndPassword(email, password);

        if (ngo != null) {

            loggedInNgoName = ngo.getNgoName();

            model.addAttribute("ngo", ngo);

            return "ngo-dashboard";
        }

        return "ngo-login-failed";
    }

    @GetMapping("/ngo/medicines")
    public String viewMedicines(Model model) {

        model.addAttribute(
                "medicines",
                medicineRepository.findAll());

        return "ngo-medicines";
    }

    @GetMapping("/ngo/claim")
    public String claimMedicine(
            @RequestParam Long id,
            Model model) {

        Medicine medicine =
                medicineRepository.findById(id).orElse(null);

        if (medicine != null &&
                "APPROVED".equals(medicine.getStatus())) {

            medicine.setStatus("CLAIMED");
            medicine.setClaimedByNgo(loggedInNgoName);
            medicine.setClaimedDate(LocalDate.now());

            medicineRepository.save(medicine);
        }

        model.addAttribute(
                "medicines",
                medicineRepository.findAll());

        return "ngo-medicines";
    }
}