package org.example.nativequery.section01.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class nativeTest {
    @Autowired
    public naitiveQueryRepository naitivequeryRepository;

    @DisplayName("결과 타입을 정의한 nativeQuery 테스트")
    @Test
    void testNativeQuery() {
        int menuCode = 1;
        Menu menu = naitivequeryRepository.nativeQuery(menuCode);
        assertNotNull(menu);
        System.out.println(menu);
    }

    @DisplayName("결과 타입을 정의할수없는 nativeQuery 테스트")
    @Test
    void testNativeNOQuery() {
        List<Object[]> menuList = naitivequeryRepository.nativeQueryNoType();
        assertNotNull(menuList);
        menuList.forEach(row -> {
            for (Object o : row) System.out.println(o);
        });
    }

    @DisplayName("자동 결과 매핑을 사용한 Native Query 조회 테스트")
    @Test
    public void testNativeQueryByAutoMapping() {
        //given
        //when
        List<Object[]> categoryList
                = naitivequeryRepository.nativeQueryByAutoMapping();
        //then
        Assertions.assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for (Object col : row) {
                        System.out.print(col + "/");
                    }
                    System.out.println();
                }
        );

    }

    @DisplayName("수동 결과 매핑을 사용한 Native Query 조회 테스트")
    @Test
    public void testNativeQueryByManualMapping() {
        //given
        //when
        List<Object[]> categoryList
                = naitivequeryRepository.nativeQueryByManualMapping();
        //then
        Assertions.assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for (Object col : row) {
                        System.out.print(col + "/");
                    }
                    System.out.println();
                }
        );
    }

}
