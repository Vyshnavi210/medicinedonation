package com.vishnavi.medicinedonation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private NGORepository ngoRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin-login";
    }

    @PostMapping("/admin/login")
    public String adminLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Admin admin =
                adminRepository.findByUsernameAndPassword(
                        username,
                        password);

        if (admin != null) {

            model.addAttribute(
                    "members",
                    memberRepository.findAll());

            model.addAttribute(
                    "ngos",
                    ngoRepository.findAll());

            model.addAttribute(
                    "medicines",
                    medicineRepository.findAll());

            return "admin-dashboard";
        }

        return "admin-login-failed";
    }

    @GetMapping("/admin/approve")
    public String approveMedicine(
            @RequestParam Long id,
            Model model) {

        Medicine medicine =
                medicineRepository.findById(id).orElse(null);

        if (medicine != null &&
                "PENDING".equals(medicine.getStatus())) {

            medicine.setStatus("APPROVED");

            medicineRepository.save(medicine);
        }

        model.addAttribute(
                "members",
                memberRepository.findAll());

        model.addAttribute(
                "ngos",
                ngoRepository.findAll());

        model.addAttribute(
                "medicines",
                medicineRepository.findAll());

        return "admin-dashboard";
    }
}