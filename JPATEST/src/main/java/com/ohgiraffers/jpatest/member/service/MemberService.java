package com.ohgiraffers.jpatest.member.service;

import com.ohgiraffers.jpatest.member.dto.MemberDTO;
import com.ohgiraffers.jpatest.member.entity.Member;
import com.ohgiraffers.jpatest.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final MemberService memberService;

    public Page<MemberDTO> list(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(), Sort.by("menuCode").descending());
        Page<Member> memberList = memberRepository.findAll(pageable);

        return memberList.map(member -> modelMapper.map(member, MemberDTO.class));
    }

    @Transactional
    public void regist(MemberDTO memberDTO) {
        memberRepository.save(modelMapper.map(memberDTO, Member.class));
    }

    @Transactional
    public void modify(MemberDTO memberDTO) {
        Member foundMember = memberRepository.findById((long) memberDTO.getMemberNo()).orElseThrow(IllegalArgumentException::new);
        foundMember.modify(memberDTO.getMemberName());
    }

    @Transactional
    public void delete(Member memberNo) {
        memberRepository.delete(memberNo);
    }
}
