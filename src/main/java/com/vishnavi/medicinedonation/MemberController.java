package com.vishnavi.medicinedonation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/member/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/member/register")
    public String registerMember(@ModelAttribute Member member) {

        member.setStatus("ACTIVE");

        memberRepository.save(member);

        return "success";
    }
}