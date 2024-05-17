package com.ohgiraffers.springdatajpa.service.menu;

import com.ohgiraffers.springdatajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


@Service
@RequiredArgsConstructor //
public class MenuService {
    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    public MenuDTO findMenuByCode(int menuCode) {
        Menu foundMenu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(foundMenu, MenuDTO.class);
    }

    //    findAll:soft
    public List<MenuDTO> findMenuList() {
        List<Menu> MenuList = menuRepository.findAll(Sort.by("menuCode").descending());

        return MenuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).toList();
    }

    //    findAll:Pageable
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0?0:pageable.getPageNumber()-1, pageable.getPageSize(), Sort.by("menuCode").descending());
        Page<Menu> menuList= menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

//    Query Methods
    public List<MenuDTO> findMenuByPrice(Integer menuPrice) {
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice, Sort.by("menuPrice").descending());
        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).toList();
    }
// JPQL OR NATIVE QUERY
    public List<CategoryDTO> findAllCategory() {


        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
    }

    @Transactional
    public void registMenu(MenuDTO menuDTO) {

        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }
@Transactional
    public void modifyMenu(MenuDTO menuDTO) {
        Menu foundMenu = menuRepository.findById(menuDTO.getMenuCode()).orElseThrow(IllegalArgumentException::new);
        foundMenu.modifyMenu(menuDTO.getMenuName());
    }
@Transactional
    public void delete(Integer menuCode) {
        menuRepository.deleteById(menuCode);

    }
}
