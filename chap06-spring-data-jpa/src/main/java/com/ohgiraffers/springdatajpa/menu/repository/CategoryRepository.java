package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //findAll 메소드로 조회 가능하지만 JPQL 설정 테스트를 위해
//    @Query("SELECT c FROM Category c")
    @Query(value = "SELECT category_Code, category_Name, ref_Category_Code FROM tbl_category order by category_Code", nativeQuery = true)
    List<Category> findAllCategory();
}
