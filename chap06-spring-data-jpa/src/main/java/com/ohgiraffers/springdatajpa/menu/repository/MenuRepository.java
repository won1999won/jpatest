package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//<엔티티,ID 타입>
public interface MenuRepository extends JpaRepository<Menu, Integer> {
//파라미터로 전달받은 가격을 초과하는 메뉴목록 조회
List<Menu>findByMenuPriceGreaterThan(Integer menuPrice);
//파라미터로 전달받은 가격을 초과하는 메뉴목록을 가격순조회
List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);

//파라미터로 전달받은 가격을 초과하는 메뉴목록을  전달받은 정렬기준으로 정렬
List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);
}
