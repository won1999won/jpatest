package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerGenerator {
<<<<<<< HEAD

    public static EntityManager getInstance() {
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
=======
    public  static EntityManager getInstance(){
        EntityManagerFactory factory=EntityManagerFactoryGenerator.getFactory();
>>>>>>> 3e5063d4ed531262628bd6961c5de00a892745c3
        return factory.createEntityManager();
    }
}
