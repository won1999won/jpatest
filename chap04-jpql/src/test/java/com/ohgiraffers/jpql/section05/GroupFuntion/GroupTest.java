package com.ohgiraffers.jpql.section05.GroupFuntion;

import com.ohgiraffers.jpql.section04.paging.PagingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroupTest {
    @Autowired
    private GroupFuntionReporsitory groupFuntionReporsitory;

    @DisplayName("특정 카테고리에 득록메유의 수 조회")
    @Test
    void testCountMenuOfCategory(){
        int categoryCode=4;
        long countmenu=groupFuntionReporsitory.countMenuCate(categoryCode);
        assertTrue(countmenu >= 4);
        System.out.println(countmenu);

    }
    @DisplayName("COUNT 외의 다른 그룹함수 조회결과가 없는 경우")
    @Test
    void testCountSumOfCategory(){
        int categoryCode=555;
//        long countmenu=groupFuntionReporsitory.otherWithNoResult(categoryCode);
//        assertTrue(countmenu >= 4);
        assertDoesNotThrow(()->{
            Long countmenu=groupFuntionReporsitory.otherWithNoResult(categoryCode);
            System.out.println(countmenu);
        });
    }

    @DisplayName("HAVING절 조회 테스트")
    @Test
    void testHaving(){
        long minPrice=50000L;
        List<Object[]> sumPriceList=groupFuntionReporsitory.selectByGroupHave(minPrice);
        assertNotNull(sumPriceList);


    }
}
