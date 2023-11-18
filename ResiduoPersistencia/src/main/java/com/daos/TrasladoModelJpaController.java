/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.TrasladoModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author PRIDE ANACONDA
 */
public class TrasladoModelJpaController implements Serializable {

    public TrasladoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrasladoModel trasladoModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trasladoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrasladoModel trasladoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trasladoModel = em.merge(trasladoModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = trasladoModel.getId();
                if (findTrasladoModel(id) == null) {
                    throw new NonexistentEntityException("The trasladoModel with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TrasladoModel trasladoModel;
            try {
                trasladoModel = em.getReference(TrasladoModel.class, id);
                trasladoModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trasladoModel with id " + id + " no longer exists.", enfe);
            }
            em.remove(trasladoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrasladoModel> findTrasladoModelEntities() {
        return findTrasladoModelEntities(true, -1, -1);
    }

    public List<TrasladoModel> findTrasladoModelEntities(int maxResults, int firstResult) {
        return findTrasladoModelEntities(false, maxResults, firstResult);
    }

    private List<TrasladoModel> findTrasladoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrasladoModel.class));
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

    public TrasladoModel findTrasladoModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrasladoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrasladoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrasladoModel> rt = cq.from(TrasladoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
