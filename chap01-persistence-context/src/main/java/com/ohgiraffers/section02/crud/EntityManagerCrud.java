package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EntityManagerCrud {
    private EntityManager entityManager;

    //    메뉴코드로 조회
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        return entityManager.find(Menu.class, menuCode);
    }

    //    메뉴 저장
    public Long saveMenu(Menu menu) {
        entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(menu);
        entityTransaction.commit();
        return getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager) {
//        JPQL 문법
        return entityManager.createQuery("SELECT count (*) from  Section02Menu ", Long.class).getSingleResult();
    }

    //    메뉴 수정
    public Menu modifyMenu(int menuCode, String menuName) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu found = entityManager.find(Menu.class, menuCode);
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        found.setMenuName(menuName);
        entityTransaction.commit();
        return found;
    }

    //    메뉴 삭제
    public Long deleteMenu(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu found = entityManager.find(Menu.class, menuCode);
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(found);
        entityTransaction.commit();
        return getCount(entityManager);

    }
}
