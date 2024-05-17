package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.service.menu.MenuService;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        MenuDTO menu = menuService.findMenuByCode(menuCode);
        model.addAttribute("menu", menu);

        return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {
        //페이징 이전
//        List<MenuDTO> menuDTOS=menuService.findMenuList();
//        model.addAttribute("menuList", menuDTOS);

        //페이징 이후
        log.info("pageable: {}", pageable);
        Page<MenuDTO> menuDTOS= menuService.findMenuList(pageable);
        log.info("{}",menuDTOS.getTotalPages());
        log.info("{}",menuDTOS.getTotalElements());
        log.info("{}",menuDTOS.getSize());
        model.addAttribute("menuList", menuDTOS);
        PagingButton paging = Pagenation.getPagingButtonInfo(menuDTOS);
        model.addAttribute("paging", paging);
        return "menu/list";
    }
    @GetMapping("/querymethod")
    public void queryMethodPage() {
    }
    @GetMapping("/search")
    public String findMenuByPrice(@RequestParam Integer menuPrice,Model model) {
        List<MenuDTO> menuDTOS = menuService.findMenuByPrice(menuPrice);
        model.addAttribute("menuList", menuDTOS);
        return "menu/searchResult";
    }
    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();

    }
    @PostMapping("/regist")
    public String registMenu(@ModelAttribute  MenuDTO menuDTO) {
        menuService.registMenu(menuDTO);
        return "redirect:/menu/list";
    }
    @GetMapping("/modify")
    public void modifyPage() {
    }
//    필드값변경
    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.modifyMenu(menuDTO);
        return "redirect:/menu"+menuDTO.getMenuCode();
    }

    @GetMapping("/delete")
    public void deletePage() {
    }
//    코드(id)로 삭제
    @PostMapping("/delete")
    public String deleteMenu(@RequestParam Integer menuCode) {
        menuService.delete(menuCode);
        return "redirect:/menu/list";
    }
}
