/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entitys.TransportistaModel;
import entitys.VehiculoModel;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author PRIDE ANACONDA
 */
public class VehiculoDAOImp implements IVehiculoDAO {

    public VehiculoDAOImp() {

    }
    private EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public VehiculoModel create(VehiculoModel vehiculoModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TransportistaModel trans = vehiculoModel.getTrans();
            if (trans != null) {
                trans = em.getReference(trans.getClass(), trans.getId());
                vehiculoModel.setTrans(trans);
            }
            em.persist(vehiculoModel);
            if (trans != null) {
                trans.getListaVehiculos().add(vehiculoModel);
                trans = em.merge(trans);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return vehiculoModel;
    }

    public List<VehiculoModel> findVehiculoModelEntities() {
        return findVehiculoModelEntities(true, -1, -1);
    }

    public List<VehiculoModel> findVehiculoModelEntities(int maxResults, int firstResult) {
        return findVehiculoModelEntities(false, maxResults, firstResult);
    }

    private List<VehiculoModel> findVehiculoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VehiculoModel.class));
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

    public VehiculoModel findVehiculoModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VehiculoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VehiculoModel> rt = cq.from(VehiculoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<VehiculoModel> obtenerVehiculosPorTransportista(Long idTransportista) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<VehiculoModel> query = em.createQuery(
                    "SELECT v FROM VehiculoModel v WHERE v.trans.id = :idTransportista", VehiculoModel.class);
            query.setParameter("idTransportista", idTransportista);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
