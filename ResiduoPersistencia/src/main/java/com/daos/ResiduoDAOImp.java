/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import code.Residuo;
import com.entitycontrollers.exceptions.NonexistentEntityException;
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
 * @author xxbry
 */
public class ResiduoDAOImp implements IResiduoDAO {

    public ResiduoDAOImp() {

    }
    
    
    public EntityManager getEntityManager() {
        return SingletonEntityManager.getEntityManagerFactory().createEntityManager();
    }

    public void guarda(Residuo residuo) {
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

    @Override
    public List<Residuo> obtenerResiduos() {
        return findResiduoEntities(true, -1, -1);
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

    @Override
    public Residuo buscarResiduoPorId(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Residuo.class, id);
        } finally {
            em.close();
        }
    }

}
