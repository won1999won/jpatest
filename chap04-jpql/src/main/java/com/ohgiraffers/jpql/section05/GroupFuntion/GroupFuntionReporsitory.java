package com.ohgiraffers.jpql.section05.GroupFuntion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupFuntionReporsitory {
    @PersistenceContext
    private EntityManager entityManager;
    public long countMenuCate(int categoryCode){
        String jpql="select count(m.menuCode) from Section05Menu m Where m.categoryCode = :categoryCode";
       Long count= entityManager.createQuery(jpql, Long.class).setParameter("categoryCode",categoryCode).getSingleResult();
        return count;

    }
    public Long otherWithNoResult(int categoryCode){
//        count 외의 다른 그룹 함수는 결과값이 없을경우 기본자요형으로 다룰 경우 문제가 생긴다
//        Long 과 같이  Wrapper 클래스 자료형으로 작성해야한다
        String jpql="select sum(m.menuPrice) from Section05Menu m Where m.categoryCode = :categoryCode";
       Long sumcount= entityManager.createQuery(jpql, Long.class).setParameter("categoryCode",categoryCode).getSingleResult();
        return sumcount;

    }
    public List<Object[]> selectByGroupHave(long minPrice){
        String jpql="select m.categoryCode,sum(m.menuPrice) from Section05Menu m"+" group by m.categoryCode having sum(m.menuPrice) >= :minPrice";
     List<Object[]> sumPrice= entityManager.createQuery(jpql).setParameter("minPrice",minPrice).getResultList();
     return sumPrice;
    }
}
