package org.example.nativequery.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class naitiveQueryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Menu nativeQuery(int menuCode) {
//        네이티브 쿼리 수행결과를 엔티티에 매핑 시키려면 모든 컬럼이 조회 되어야 가능
        String sql = "SELECT menu_code, menu_name, menu_price, category_code, orderable_status"+" FROM tbl_menu WHERE menu_code =?";
        Query nativeQuery = entityManager.createNativeQuery(sql, Menu.class).setParameter(1, menuCode);
        return (Menu) nativeQuery.getSingleResult();
    }
    public List<Object[]> nativeQueryNoType(){
        String sql = "SELECT menu_code,menu_name, menu_price, category_code, orderable_status";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        return nativeQuery.getResultList();
    }
    public List<Object[]> nativeQueryByAutoMapping() {
        String query
                = "SELECT a.category_code, a.category_name, a.ref_category_code," +
                " COALESCE(v.menu_count, 0) menu_count" +
                " FROM tbl_category a" +
                " LEFT JOIN (SELECT COUNT(*) AS menu_count, b.category_code" +
                " FROM tbl_menu b" +
                " GROUP BY b.category_code) v ON (a.category_code = v.category_code)" +
                " ORDER BY 1";
        Query nativeQuery
                = entityManager.createNativeQuery(query, "categoryCountAutoMapping");
        return nativeQuery.getResultList();
    }
    public List<Object[]> nativeQueryByManualMapping() {
        String query
                = "SELECT a.category_code, a.category_name, a.ref_category_code," +
                " COALESCE(v.menu_count, 0) menu_count" +
                " FROM tbl_category a" +
                " LEFT JOIN (SELECT COUNT(*) AS menu_count, b.category_code" +
                " FROM tbl_menu b" +
                " GROUP BY b.category_code) v ON (a.category_code = v.category_code)" +
                " ORDER BY 1";
        Query nativeQuery
                = entityManager.createNativeQuery(query, "categoryCountManualMapping");
        return nativeQuery.getResultList();
    }


}
