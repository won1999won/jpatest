package com.ohgiraffers.jpatest.member.controller;

import com.ohgiraffers.jpatest.common.Pagenation;
import com.ohgiraffers.jpatest.common.PagingButton;
import com.ohgiraffers.jpatest.member.dto.MemberDTO;
import com.ohgiraffers.jpatest.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/list")
    public String list(Model model, @PageableDefault Pageable pageable) {
        Page<MemberDTO> memberDTOS = memberService.list(pageable);
        PagingButton pagingButton= Pagenation.getPagingButtonInfo(memberDTOS);
        model.addAttribute("memberList", memberDTOS);
        model.addAttribute("paging", pagingButton);
        return "member/list";
    }
    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping("/regist")
    public String regist(@ModelAttribute MemberDTO memberDTO) {
        memberService.regist(memberDTO);
        return "redirect:member/regist";
    }
    @GetMapping("/modify")
    public void modifyPage() {
    }
    @GetMapping("/modify")
    public String modify(@ModelAttribute MemberDTO memberDTO) {
        memberService.modify(memberDTO);
        return "redirect:member/modify";
    }
    @GetMapping("/delete")
    public void deletePage() {
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer memberNo) {
        memberService.delete(memberNo);
        return "redirect:member/list";
    }
}
