/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import static java.util.Collections.singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase Singleton para la gestión de EntityManagerFactory. 
 * @author PRIDE ANACONDA
 */
public class SingletonEntityManager {

    private static EntityManagerFactory entityManagerFactory = null;

    private SingletonEntityManager() {
        // Constructor privado para evitar instanciación externa.
    }

    /**
     * Obtiene la instancia única de EntityManagerFactory. Si no existe, se
     * crea.
     *
     * @return Instancia única de EntityManagerFactory.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("mysqlPU");
        }
        return entityManagerFactory;
    }
}
