package com.example.controller;


import com.example.entity.Member;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<Member> selectMembers() {
        return memberService.selectMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
