package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntityManagerGeneratorTest {
    @Test
    @DisplayName("팩토리 생성")
    void testGeneratorEntityManagerFactory(){

        //given

        //when
        EntityManagerFactory factory=EntityManagerFactoryGenerator.getFactory();

        //then
        assertNotNull(factory);

    }
    @Test
    @DisplayName("팩토리 인스턴스")
    void testIs(){

        //given

        //when
        EntityManagerFactory factory=EntityManagerFactoryGenerator.getFactory();
        EntityManagerFactory factory2=EntityManagerFactoryGenerator.getFactory();

        //then
        assertEquals(factory,factory2);

    }
    @Test
    @DisplayName("엔티티 매니저")
    void testManager(){

        EntityManager entityManager=EntityManagerGenerator.getInstance();
        assertNotNull(entityManager);
    }
    @Test
    @DisplayName("엔티티 매니저 스코프")
    void testCycle(){

        EntityManager entityManager=EntityManagerGenerator.getInstance();
        EntityManager entityManager2=EntityManagerGenerator.getInstance();
        assertNotEquals(entityManager,entityManager2);


    }

}
