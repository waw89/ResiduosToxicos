/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entitycontrollers;

import code.Traslado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import code.Vehiculo;
import com.entitycontrollers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author xxbry
 */
public class TrasladoJpaController implements Serializable {

    public TrasladoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Traslado traslado) {
        if (traslado.getListaVehiculos() == null) {
            traslado.setListaVehiculos(new ArrayList<Vehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Vehiculo> attachedListaVehiculos = new ArrayList<Vehiculo>();
            for (Vehiculo listaVehiculosVehiculoToAttach : traslado.getListaVehiculos()) {
                listaVehiculosVehiculoToAttach = em.getReference(listaVehiculosVehiculoToAttach.getClass(), listaVehiculosVehiculoToAttach.getId());
                attachedListaVehiculos.add(listaVehiculosVehiculoToAttach);
            }
            traslado.setListaVehiculos(attachedListaVehiculos);
            em.persist(traslado);
            for (Vehiculo listaVehiculosVehiculo : traslado.getListaVehiculos()) {
                code.Vehiculo oldVehOfListaVehiculosVehiculo = listaVehiculosVehiculo.getVeh();
                listaVehiculosVehiculo.setVeh(traslado);
                listaVehiculosVehiculo = em.merge(listaVehiculosVehiculo);
                if (oldVehOfListaVehiculosVehiculo != null) {
                    oldVehOfListaVehiculosVehiculo.getListaVehiculos().remove(listaVehiculosVehiculo);
                    oldVehOfListaVehiculosVehiculo = em.merge(oldVehOfListaVehiculosVehiculo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Traslado traslado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Traslado persistentTraslado = em.find(Traslado.class, traslado.getId());
            List<Vehiculo> listaVehiculosOld = persistentTraslado.getListaVehiculos();
            List<Vehiculo> listaVehiculosNew = traslado.getListaVehiculos();
            List<Vehiculo> attachedListaVehiculosNew = new ArrayList<Vehiculo>();
            for (Vehiculo listaVehiculosNewVehiculoToAttach : listaVehiculosNew) {
                listaVehiculosNewVehiculoToAttach = em.getReference(listaVehiculosNewVehiculoToAttach.getClass(), listaVehiculosNewVehiculoToAttach.getId());
                attachedListaVehiculosNew.add(listaVehiculosNewVehiculoToAttach);
            }
            listaVehiculosNew = attachedListaVehiculosNew;
            traslado.setListaVehiculos(listaVehiculosNew);
            traslado = em.merge(traslado);
            for (Vehiculo listaVehiculosOldVehiculo : listaVehiculosOld) {
                if (!listaVehiculosNew.contains(listaVehiculosOldVehiculo)) {
                    listaVehiculosOldVehiculo.setVeh(null);
                    listaVehiculosOldVehiculo = em.merge(listaVehiculosOldVehiculo);
                }
            }
            for (Vehiculo listaVehiculosNewVehiculo : listaVehiculosNew) {
                if (!listaVehiculosOld.contains(listaVehiculosNewVehiculo)) {
                    Traslado oldVehOfListaVehiculosNewVehiculo = listaVehiculosNewVehiculo.getVeh();
                    listaVehiculosNewVehiculo.setVeh(traslado);
                    listaVehiculosNewVehiculo = em.merge(listaVehiculosNewVehiculo);
                    if (oldVehOfListaVehiculosNewVehiculo != null && !oldVehOfListaVehiculosNewVehiculo.equals(traslado)) {
                        oldVehOfListaVehiculosNewVehiculo.getListaVehiculos().remove(listaVehiculosNewVehiculo);
                        oldVehOfListaVehiculosNewVehiculo = em.merge(oldVehOfListaVehiculosNewVehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = traslado.getId();
                if (findTraslado(id) == null) {
                    throw new NonexistentEntityException("The traslado with id " + id + " no longer exists.");
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
            Traslado traslado;
            try {
                traslado = em.getReference(Traslado.class, id);
                traslado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The traslado with id " + id + " no longer exists.", enfe);
            }
            List<Vehiculo> listaVehiculos = traslado.getListaVehiculos();
            for (Vehiculo listaVehiculosVehiculo : listaVehiculos) {
                listaVehiculosVehiculo.setVeh(null);
                listaVehiculosVehiculo = em.merge(listaVehiculosVehiculo);
            }
            em.remove(traslado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Traslado> findTrasladoEntities() {
        return findTrasladoEntities(true, -1, -1);
    }

    public List<Traslado> findTrasladoEntities(int maxResults, int firstResult) {
        return findTrasladoEntities(false, maxResults, firstResult);
    }

    private List<Traslado> findTrasladoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Traslado.class));
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

    public Traslado findTraslado(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Traslado.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrasladoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Traslado> rt = cq.from(Traslado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
