package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepsitory MemberRepsitory;

    @GetMapping("/signup")
    public String signup(){
        return "members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form){
        Member member = form.toEntity();
        log.info(member.toString());

        Member saved = MemberRepsitory.save(member);
        log.info(saved.toString());

        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member memberEntity = MemberRepsitory.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        log.warn(memberEntity.toString());
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        List<Member> memberEntityList = (List<Member>) MemberRepsitory.findAll();
        log.warn(memberEntityList.toString());
        model.addAttribute("memberList", memberEntityList);
        return "members/index";
    }
}
