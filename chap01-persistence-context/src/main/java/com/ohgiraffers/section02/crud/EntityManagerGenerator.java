package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerFactoryGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerGenerator {
<<<<<<< HEAD

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerGenerator() {}

    public static EntityManager getInstance() {
=======
    private static EntityManagerFactory factory= Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerGenerator(){}

    public  static EntityManager getInstance(){
        EntityManagerFactory factory= EntityManagerFactoryGenerator.getFactory();
>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
        return factory.createEntityManager();
    }
}
