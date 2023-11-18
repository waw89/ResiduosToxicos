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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PRIDE ANACONDA
 */
public class VehiculoModelJpaController implements Serializable {

    public VehiculoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VehiculoModel vehiculoModel) {
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
    }

    public void edit(VehiculoModel vehiculoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VehiculoModel persistentVehiculoModel = em.find(VehiculoModel.class, vehiculoModel.getId());
            TransportistaModel transOld = persistentVehiculoModel.getTrans();
            TransportistaModel transNew = vehiculoModel.getTrans();
            if (transNew != null) {
                transNew = em.getReference(transNew.getClass(), transNew.getId());
                vehiculoModel.setTrans(transNew);
            }
            vehiculoModel = em.merge(vehiculoModel);
            if (transOld != null && !transOld.equals(transNew)) {
                transOld.getListaVehiculos().remove(vehiculoModel);
                transOld = em.merge(transOld);
            }
            if (transNew != null && !transNew.equals(transOld)) {
                transNew.getListaVehiculos().add(vehiculoModel);
                transNew = em.merge(transNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = vehiculoModel.getId();
                if (findVehiculoModel(id) == null) {
                    throw new NonexistentEntityException("The vehiculoModel with id " + id + " no longer exists.");
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
            VehiculoModel vehiculoModel;
            try {
                vehiculoModel = em.getReference(VehiculoModel.class, id);
                vehiculoModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculoModel with id " + id + " no longer exists.", enfe);
            }
            TransportistaModel trans = vehiculoModel.getTrans();
            if (trans != null) {
                trans.getListaVehiculos().remove(vehiculoModel);
                trans = em.merge(trans);
            }
            em.remove(vehiculoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
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
    
}
