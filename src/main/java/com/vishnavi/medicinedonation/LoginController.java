package com.vishnavi.medicinedonation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/member/login")
    public String loginPage() {
        return "member-login";
    }

    @PostMapping("/member/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        Member member =
                memberRepository.findByEmailAndPassword(email, password);

        if(member != null) {
            model.addAttribute("member", member);
            return "member-dashboard";
        }

        return "login-failed";
    }
}