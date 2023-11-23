package com.mongodb.controller;

import com.mongodb.document.Member;
import com.mongodb.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/member/{id}")
    public Member findById(@PathVariable String id) {
        return memberRepository.findById(id).get();
    }

    @GetMapping("/member")
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @PostMapping("/member")
    public Member save(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @PutMapping("/member/{id}")
    public Member update(@RequestBody Member request,@PathVariable String id) {
        Member member = memberRepository.findById(id).orElse(null);
        member.setMember_id(request.getMember_id());
        member.setMember_name(request.getMember_name());
        member.setMail(request.getMail());
        return memberRepository.save(member);
    }

    @DeleteMapping("/member/{id}")
    public boolean deleteById(@PathVariable String id) {
        memberRepository.deleteById(id);
        return true;
    }
}