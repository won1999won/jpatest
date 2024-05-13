package com.ohgiraffers.jpql.section06.join;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JoinRepositorytests {

    @Autowired
    public JoinRepository joinRepository;

    @DisplayName("내부조인")
    @Test
    void testSelectByInnerJoin() {
        List<Menu> menuList = joinRepository.selectByInnerJoin();
        assertNotNull(menuList);
    }

    @DisplayName("외부조인")
    @Test
    void testSelectByOuterJoin() {
        List<Object[]> menuList = joinRepository.selectByOuterJoin();
        assertNotNull(menuList);
        menuList.forEach(row -> {
            for (Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        });
    }

    @DisplayName("컬렉션 조인")
    @Test
    void testSelectByColJoin() {
        List<Object[]> categoryList = joinRepository.selectByCollectionJoin();
        assertNotNull(categoryList);
        categoryList.forEach(row -> {
            for (Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        });
    }

    @DisplayName("세타 조인")
    @Test
    void testSelectByThetaJoin() {
        List<Object[]> categoryList = joinRepository.selectByThetaJoin();
        assertNotNull(categoryList);
        categoryList.forEach(row -> {
            for (Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        });

    }
    @DisplayName("내부조인")
    @Test
    void testSelectByFetchJoin() {
        List<Menu> menuList = joinRepository.selectByFetchJoin();
        assertNotNull(menuList);
    }

}
