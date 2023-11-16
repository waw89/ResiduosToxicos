/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import code.Quimico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author xxbry
 */
public class QuimicoDAOImp implements IQuimicoDAO {

    public QuimicoDAOImp() {
        
    }
    
    EntityManager entityManager = SingletonEntityManager.getEntityManagerFactory().createEntityManager(); 
   
    public EntityManager getEntityManager() {
        return entityManager; 
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

    public List<Quimico> cargaQuimicos(List<Quimico> quimicos) {
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            for(Quimico quim: quimicos){
                em.persist(quim);
            }
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return quimicos;
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
