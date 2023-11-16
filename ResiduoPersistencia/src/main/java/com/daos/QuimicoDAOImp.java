/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import code.Quimico;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author xxbry
 */
public class QuimicoDAOImp implements Serializable {

    public QuimicoDAOImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    // para usar el singleton, 
    public void create(Quimico quimico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(quimico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Quimico> cargaQuimicos(List<Quimico> listaQuimicos) {
        EntityManager em = null ;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            for (Quimico quimico: listaQuimicos){
                em.persist(quimico);
                em.getTransaction().commit();
            }
            
            em.close();
            return listaQuimicos;
            
        }catch(Exception e){
         
           e.printStackTrace();
           
        }
       return null;
    }
    public List<Quimico> findQuimicoEntities() {
        return findQuimicoEntities(true, -1, -1);
    }

    public List<Quimico> findQuimicoEntities(int maxResults, int firstResult) {
        return findQuimicoEntities(false, maxResults, firstResult);
    }

    private List<Quimico> findQuimicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Quimico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Quimico findQuimico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Quimico.class, id);
        } finally {
            em.close();
        }
    }

    public int getQuimicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Quimico> rt = cq.from(Quimico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
