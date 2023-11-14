/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entitycontrollers;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import code.Transportista;
import code.Vehiculo;
import com.entitycontrollers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author xxbry
 */
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transportista trans = vehiculo.getTrans();
            if (trans != null) {
                trans = em.getReference(trans.getClass(), trans.getId());
                vehiculo.setTrans(trans);
            }
            Vehiculo veh = vehiculo.getVeh();
            if (veh != null) {
                veh = em.getReference(veh.getClass(), veh.getId());
                vehiculo.setVeh(veh);
            }
            em.persist(vehiculo);
            if (trans != null) {
                trans.getListaVehiculos().add(vehiculo);
                trans = em.merge(trans);
            }
            if (veh != null) {
                Vehiculo oldVehOfVeh = veh.getVeh();
                if (oldVehOfVeh != null) {
                    oldVehOfVeh.setVeh(null);
                    oldVehOfVeh = em.merge(oldVehOfVeh);
                }
                veh.setVeh(vehiculo);
                veh = em.merge(veh);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getId());
            Transportista transOld = persistentVehiculo.getTrans();
            Transportista transNew = vehiculo.getTrans();
            Vehiculo vehOld = persistentVehiculo.getVeh();
            Vehiculo vehNew = vehiculo.getVeh();
            if (transNew != null) {
                transNew = em.getReference(transNew.getClass(), transNew.getId());
                vehiculo.setTrans(transNew);
            }
            if (vehNew != null) {
                vehNew = em.getReference(vehNew.getClass(), vehNew.getId());
                vehiculo.setVeh(vehNew);
            }
            vehiculo = em.merge(vehiculo);
            if (transOld != null && !transOld.equals(transNew)) {
                transOld.getListaVehiculos().remove(vehiculo);
                transOld = em.merge(transOld);
            }
            if (transNew != null && !transNew.equals(transOld)) {
                transNew.getListaVehiculos().add(vehiculo);
                transNew = em.merge(transNew);
            }
            if (vehOld != null && !vehOld.equals(vehNew)) {
                vehOld.setVeh(null);
                vehOld = em.merge(vehOld);
            }
            if (vehNew != null && !vehNew.equals(vehOld)) {
                Vehiculo oldVehOfVeh = vehNew.getVeh();
                if (oldVehOfVeh != null) {
                    oldVehOfVeh.setVeh(null);
                    oldVehOfVeh = em.merge(oldVehOfVeh);
                }
                vehNew.setVeh(vehiculo);
                vehNew = em.merge(vehNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = vehiculo.getId();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
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
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            Transportista trans = vehiculo.getTrans();
            if (trans != null) {
                trans.getListaVehiculos().remove(vehiculo);
                trans = em.merge(trans);
            }
            Vehiculo veh = vehiculo.getVeh();
            if (veh != null) {
                veh.setVeh(null);
                veh = em.merge(veh);
            }
            em.remove(vehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
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

    public Vehiculo findVehiculo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
