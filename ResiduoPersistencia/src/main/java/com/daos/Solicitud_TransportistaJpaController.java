/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Solicitud_Transportista;
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
 * @author marcos_zr
 */
public class Solicitud_TransportistaJpaController implements Serializable {

    public Solicitud_TransportistaJpaController() {
        
    }
    EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Solicitud_Transportista solicitud_Transportista) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(solicitud_Transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Solicitud_Transportista solicitud_Transportista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            solicitud_Transportista = em.merge(solicitud_Transportista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = solicitud_Transportista.getId();
                if (findSolicitud_Transportista(id) == null) {
                    throw new NonexistentEntityException("The solicitud_Transportista with id " + id + " no longer exists.");
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
            Solicitud_Transportista solicitud_Transportista;
            try {
                solicitud_Transportista = em.getReference(Solicitud_Transportista.class, id);
                solicitud_Transportista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitud_Transportista with id " + id + " no longer exists.", enfe);
            }
            em.remove(solicitud_Transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Solicitud_Transportista> findSolicitud_TransportistaEntities() {
        return findSolicitud_TransportistaEntities(true, -1, -1);
    }

    public List<Solicitud_Transportista> findSolicitud_TransportistaEntities(int maxResults, int firstResult) {
        return findSolicitud_TransportistaEntities(false, maxResults, firstResult);
    }

    private List<Solicitud_Transportista> findSolicitud_TransportistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Solicitud_Transportista.class));
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

    public Solicitud_Transportista findSolicitud_Transportista(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Solicitud_Transportista.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitud_TransportistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Solicitud_Transportista> rt = cq.from(Solicitud_Transportista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
