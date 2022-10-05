package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.MemberDto;
import com.ecommerce.backend.entity.Member;
import com.ecommerce.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }


    public MemberDto getMemberById(Long id) {
        Member member = memberRepository.findById(id).get();

        MemberDto memberDto = new MemberDto();
        BeanUtils.copyProperties(member,memberDto);
        return memberDto;

    }

    public MemberDto updateMember(Long id, MemberDto memberDto) {

        Member member = memberRepository.findById(id).get();

        member.setEmailId(memberDto.getEmailId());
        member.setName(memberDto.getName());
        member.setAddress(memberDto.getAddress());

        memberRepository.save(member);
        return memberDto;
    }

    public boolean deleteMember(Long id) {
        Member member = memberRepository.findById(id).get();
        memberRepository.delete(member);
        return true;
    }
}
