/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Especificacion_Residuos;
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
public class EspecificacionResiduosDAOImp implements IEspecificacionDAO {

    public EspecificacionResiduosDAOImp() {
        
    }
    private EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    @Override
    public void edit(Especificacion_Residuos especificacion_Residuos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            especificacion_Residuos = em.merge(especificacion_Residuos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = especificacion_Residuos.getId();
                if (findEspecificacion_Residuos(id) == null) {
                    throw new NonexistentEntityException("The especificacion_Residuos with id " + id + " no longer exists.");
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
            Especificacion_Residuos especificacion_Residuos;
            try {
                especificacion_Residuos = em.getReference(Especificacion_Residuos.class, id);
                especificacion_Residuos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especificacion_Residuos with id " + id + " no longer exists.", enfe);
            }
            em.remove(especificacion_Residuos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities() {
        return findEspecificacion_ResiduosEntities(true, -1, -1);
    }

    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(int maxResults, int firstResult) {
        return findEspecificacion_ResiduosEntities(false, maxResults, firstResult);
    }

    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especificacion_Residuos.class));
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

    public Especificacion_Residuos findEspecificacion_Residuos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especificacion_Residuos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecificacion_ResiduosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especificacion_Residuos> rt = cq.from(Especificacion_Residuos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
