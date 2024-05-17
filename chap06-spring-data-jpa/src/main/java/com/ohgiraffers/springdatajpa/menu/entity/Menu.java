package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //접근제한이 설정된 기본생성자
//@Setter 일반적으로는 사용히지않음 -> 데이터의 변형위험이있음
//변경이 필요한 경우에만 해당 기능을 가진 메소드를 호출
//@AllArgsConstructor -> 모든 필드를 초기화 하는 생성자
//@ToString -> 모든 필드의 값을 포함하는 toString 메소드 생성,사용은 가능하나 연관관계 매핑필드는 제거 후 사용
public class Menu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public void modifyMenu(String menuName) {
        this.menuName = menuName;
    }
}
