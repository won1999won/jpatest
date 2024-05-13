package com.ohgiraffers.jpql.section07.subQuery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class subQueryTest {
    @Autowired
    public SubQueryRepository subQueryRepository;

    @DisplayName("서브쿼리 조회")
    @Test
    void testSelectBySubQuery() {
        String categoryName = "한식";
        List<Menu> menuList = subQueryRepository.selectWithSubQuery(categoryName);
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
}
