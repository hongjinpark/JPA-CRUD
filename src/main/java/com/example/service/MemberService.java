package com.example.service;


import com.example.entity.Member;
import com.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> selectMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public Member updateMember(Long id, Member member) {
        Member memberData = memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        memberData.update(member.getName(), member.getAddress());
        return memberData;
    }
}
