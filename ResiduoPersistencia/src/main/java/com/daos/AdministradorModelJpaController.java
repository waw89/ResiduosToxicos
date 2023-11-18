/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.AdministradorModel;
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
public class AdministradorModelJpaController implements Serializable {

    public AdministradorModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AdministradorModel administradorModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(administradorModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AdministradorModel administradorModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            administradorModel = em.merge(administradorModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = administradorModel.getId();
                if (findAdministradorModel(id) == null) {
                    throw new NonexistentEntityException("The administradorModel with id " + id + " no longer exists.");
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
            AdministradorModel administradorModel;
            try {
                administradorModel = em.getReference(AdministradorModel.class, id);
                administradorModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administradorModel with id " + id + " no longer exists.", enfe);
            }
            em.remove(administradorModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AdministradorModel> findAdministradorModelEntities() {
        return findAdministradorModelEntities(true, -1, -1);
    }

    public List<AdministradorModel> findAdministradorModelEntities(int maxResults, int firstResult) {
        return findAdministradorModelEntities(false, maxResults, firstResult);
    }

    private List<AdministradorModel> findAdministradorModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AdministradorModel.class));
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

    public AdministradorModel findAdministradorModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AdministradorModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AdministradorModel> rt = cq.from(AdministradorModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
