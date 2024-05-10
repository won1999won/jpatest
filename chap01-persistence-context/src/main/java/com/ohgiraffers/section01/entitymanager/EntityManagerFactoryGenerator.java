package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
<<<<<<< HEAD

public class EntityManagerFactoryGenerator {

    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("jpatest");

    private EntityManagerFactoryGenerator() {}

    public static EntityManagerFactory getInstance() {
=======
public class EntityManagerFactoryGenerator {
    private static EntityManagerFactory factory= Persistence.createEntityManagerFactory("jpatest");
    private EntityManagerFactoryGenerator(){}
    public static EntityManagerFactory getFactory(){
>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
        return factory;
    }
}
