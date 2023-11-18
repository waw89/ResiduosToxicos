/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import entitys.ResiduoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author xfs85
 */
public class ResiduoDAOImp implements IResiduoDAO{
    
     public ResiduoDAOImp() {

    }
    
     EntityManagerFactory entityManagerFactory = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    
    

    @Override
    public ResiduoModel crear(ResiduoModel residuo) {
    EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(residuo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return residuo; 
    }

    @Override
    public List<ResiduoModel> cargaResiduos(List<ResiduoModel> residuos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResiduoModel findResiduo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResiduoModel findResiduoNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
