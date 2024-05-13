package com.ohgiraffers.jpql.section08.namedQuery;

import com.ohgiraffers.jpql.section08.Menu;
import com.ohgiraffers.jpql.section08.namedQueryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class namedQueryTest {
    @Autowired
    public namedQueryRepository namedqueryRepository;




    @DisplayName("동적쿼리 조회")
    @Test
    public void testSelectByDynamicQuery() {
        String Name = null;
        int code=4;
        List<Menu> menuList = namedqueryRepository.selectByDynamicQuery(Name,code);
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
    @DisplayName("NamedQuery로 조회")
    @Test
    public void testSelectByNamedQuery() {
        List<Menu> menuList = namedqueryRepository.selectByName();
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
    @DisplayName("NamedQuery Xml로 조회")
    @Test
    public void testSelectByXmlNamedQuery() {
        String Name = null;
        int code=4;
        List<Menu> menuList = namedqueryRepository.selectByNamexml(code);
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

}
