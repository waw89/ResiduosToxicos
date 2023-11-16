/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daosimp;

import static java.util.Collections.singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PRIDE ANACONDA
 */
public class SingletonConexion {

    private static EntityManager entityManager;

    private SingletonConexion() {
    }

    public static EntityManager getSingleton() {
        if (entityManager == null) {
          
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysqlPU");
            entityManager = entityManagerFactory.createEntityManager();

        }
        return entityManager;
    }
}
