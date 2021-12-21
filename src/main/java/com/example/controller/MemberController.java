package com.example.controller;


import com.example.dto.MemberDto;
import com.example.entity.Member;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostConstruct
    private void init() {
        MemberDto member = new MemberDto();
        member.setName("kim");
        member.setAddress("seoul");
        memberService.saveMember(member);

        MemberDto member1 = new MemberDto();
        member1.setName("park");
        member1.setAddress("busan");
        memberService.saveMember(member1);

    }

    @GetMapping
    public List<Member> selectMembers() {
        return memberService.selectMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping
    public Member saveMember(@RequestBody MemberDto member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody MemberDto member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
