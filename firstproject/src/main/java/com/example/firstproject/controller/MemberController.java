package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepsitory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepsitory MemberRepsitory;

    @GetMapping("members/signup")
    public String signup(){
        return "members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form){
        Member memberEntity = form.toEntity();
        log.info(memberEntity.toString());

        Member saved = MemberRepsitory.save(memberEntity);

        return "";
    }
}
