/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mysql;

import code.Residuo;
import com.dao.exceptions.NonexistentEntityException;
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
public class ResiduoJpaController implements Serializable {

    public ResiduoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public ResiduoJpaController (){
        emf =Persistence.createEntityManagerFactory("mysqlPU");
    }
    public void create(Residuo residuo) {
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
    }

    public void edit(Residuo residuo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            residuo = em.merge(residuo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = residuo.getId();
                if (findResiduo(id) == null) {
                    throw new NonexistentEntityException("The residuo with id " + id + " no longer exists.");
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
            Residuo residuo;
            try {
                residuo = em.getReference(Residuo.class, id);
                residuo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The residuo with id " + id + " no longer exists.", enfe);
            }
            em.remove(residuo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Residuo> findResiduoEntities() {
        return findResiduoEntities(true, -1, -1);
    }

    public List<Residuo> findResiduoEntities(int maxResults, int firstResult) {
        return findResiduoEntities(false, maxResults, firstResult);
    }

    private List<Residuo> findResiduoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Residuo.class));
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

    public Residuo findResiduo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Residuo.class, id);
        } finally {
            em.close();
        }
    }

    public int getResiduoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Residuo> rt = cq.from(Residuo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
