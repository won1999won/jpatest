package com.ohgiraffers.jpql.section04.paging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PagingTest {
    @Autowired
    private PagingRepository pagingRepository;
    @DisplayName("페이징 api로 조회")
    @Test
    void testUserPagingAPI(){
        int offset=10;
        int limit=5;


        List<Menu> menuList=pagingRepository.usingPasingAPI(offset,limit);
        assertTrue(menuList.size()>0 && menuList.size()<6);
        menuList.forEach(System.out::println);
    }
}
