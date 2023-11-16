/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import code.Quimico;
import com.daos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author PRIDE ANACONDA
 */
public class QuimicoJpaController implements Serializable {

   public QuimicoJpaController() {
     
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


     public void create(List<Quimico> quimicos) {
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
    }

    public void edit(Quimico quimico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            quimico = em.merge(quimico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = quimico.getId();
                if (findQuimico(id) == null) {
                    throw new NonexistentEntityException("The quimico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Quimico quimico;
            try {
                quimico = em.getReference(Quimico.class, id);
                quimico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The quimico with id " + id + " no longer exists.", enfe);
            }
            em.remove(quimico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
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
