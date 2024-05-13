package com.ohgiraffers.jpql.section04.paging;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagingRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Menu> usingPasingAPI(int offset,int limit){
        String jpql="SELECT m from Section04Menu m Order by m.menuCode desc";
        List<Menu> pagingMenuList =entityManager.createQuery(jpql, Menu.class)
                .setFirstResult(offset).setMaxResults(limit).getResultList();
        return pagingMenuList;
    }

}
