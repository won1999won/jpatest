package com.ohgiraffers.section02.crud;

import jakarta.persistence.*;

<<<<<<< HEAD
@Entity(name = "Section02Menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    protected Menu() {}

    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
=======
@Entity(name="Section02Menu")
@Table(name = "tbl_menu")
public class Menu {
    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int menuCode;
    @Column(name="menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name="category_code")
    private int categoryCode;
    @Column(name = "orderable_status")
    private String orderableStatus;

    public Menu() {

    }

    public Menu( String menuName, int menuPrice, int categoryCode, String orderableStatus) {

>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

<<<<<<< HEAD
=======


>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
    public int getMenuCode() {
        return menuCode;
    }

<<<<<<< HEAD
    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

=======
>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

<<<<<<< HEAD
=======
    public String getMenuName() {
        return menuName;
    }

>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

<<<<<<< HEAD
=======
    public int getMenuPrice() {
        return menuPrice;
    }

>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

<<<<<<< HEAD
=======
    public int getCategoryCode() {
        return categoryCode;
    }

>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

<<<<<<< HEAD
=======
    public String getOrderableStatus() {
        return orderableStatus;
    }

>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
