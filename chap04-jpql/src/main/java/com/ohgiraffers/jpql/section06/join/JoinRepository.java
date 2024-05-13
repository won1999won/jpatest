package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectByInnerJoin(){
        String jpql="select m from Section06Menu m Join m.category c";
        List<Menu> menuList=entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }
    public List<Object[]> selectByOuterJoin(){
        String jpql="select m.menuName,c.categoryName from Section06Menu m  right Join m.category c"+" order by m.category.categoryCode";
        List<Object[]>menuList=entityManager.createQuery(jpql).getResultList();
        return menuList;
    }
    public List<Object[]> selectByCollectionJoin(){
        String jpql="select m.menuName,c.categoryName from Section06Category c  LEFT Join c.menuList m";
        List<Object[]>categoryList=entityManager.createQuery(jpql).getResultList();
        return categoryList;
    }
    public List<Object[]> selectByThetaJoin(){
        String jpql="select m.menuName,c.categoryName from Section06Category c ,Section01Menu m";
        List<Object[]>categoryList=entityManager.createQuery(jpql).getResultList();
        return categoryList;
    }    public List<Menu> selectByFetchJoin(){
        String jpql="select m from Section06Menu m Join fetch m.category c";
        List<Menu> menuList=entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }

}
