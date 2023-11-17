/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import entitys.QuimicoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

    EntityManagerFactory entityManagerFactory = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // para usar el singleton, 
    public void create(QuimicoModel quimico) {
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

    public boolean verificaQuimicos() {

        if (findQuimicoEntities() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<QuimicoModel> cargaQuimicos(List<QuimicoModel> quimicos) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (verificaQuimicos() == true) {
                for (QuimicoModel quimico : quimicos) {
                    em.persist(quimico);
                }

                transaction.commit();
            } else {
                return findQuimicoEntities();
            }

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Puedes manejar la excepción o relanzarla según tus necesidades
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return quimicos;
    }

    public List<QuimicoModel> findQuimicoEntities() {
        return findQuimicoEntities(true, -1, -1);
    }

    public List<QuimicoModel> findQuimicoEntities(int maxResults, int firstResult) {
        return findQuimicoEntities(false, maxResults, firstResult);
    }

    private List<QuimicoModel> findQuimicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(QuimicoModel.class));
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

    public QuimicoModel findQuimico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(QuimicoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getQuimicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<QuimicoModel> rt = cq.from(QuimicoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
