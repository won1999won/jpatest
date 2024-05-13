package com.ohgiraffers.jpql.section07.subQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubQueryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> selectWithSubQuery(String categoryName) {
        String jpql = "SELECT m FROM Section07Menu m WHERE m.categoryCode = (SELECT c.categoryCode FROM Section07Category c " +
                "WHERE c.categoryName = :categoryName)";
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
        return menuList;
    }


}
