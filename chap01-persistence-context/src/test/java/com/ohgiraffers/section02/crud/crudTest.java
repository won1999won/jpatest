package com.ohgiraffers.section02.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class crudTest {
    private EntityManagerCrud crud;

    @BeforeEach
    void initManager() {
        this.crud = new EntityManagerCrud();
    }

    @DisplayName("조회")
    @ParameterizedTest //하나의 메소드로 여러 파라미터의 테스트가능
    @CsvSource({"2,2","3,3"})
    void testCode(int menuCode,int expected) {
        Menu found = crud.findMenuByMenuCode(menuCode);
        assertEquals(expected, found.getMenuCode());
        System.out.println(":"+found);
    }
    private static Stream<Arguments> newMenu(){
        return Stream.of(Arguments.of("신메뉴",45000,4,"Y"));
    }

    @DisplayName("추가")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testSAVE(String menuName,int menuPrice, int categoryCode,String oderableStatus){
        Menu newMenu=new Menu(menuName,menuPrice,categoryCode,oderableStatus);
        Long count=crud.saveMenu(newMenu);
        assertEquals(28,count);
    }
    @DisplayName("수정")
    @ParameterizedTest
    @CsvSource("2,이름")
    void testModify(int menuCode,String menuName){
        Menu menu=crud.modifyMenu(menuCode,menuName);
        assertEquals(menuCode,menu.getMenuName());
    }
    @DisplayName("삭제")
    @ParameterizedTest
    @ValueSource(ints = {32})
    void testDelete(int menuCode){
        Long count = crud.deleteMenu(menuCode);
        assertEquals(29,count);
    }

}
