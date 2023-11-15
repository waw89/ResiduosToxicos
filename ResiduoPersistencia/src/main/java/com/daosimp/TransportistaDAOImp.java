/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daosimp;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import code.SolicitudTraslado;
import code.Transportista;
import java.util.ArrayList;
import java.util.List;
import code.Vehiculo;
import com.entitycontrollers.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author xxbry
 */
public class TransportistaDAOImp implements Serializable {

    public TransportistaDAOImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transportista transportista) {
        if (transportista.getListaSolicitudes() == null) {
            transportista.setListaSolicitudes(new ArrayList<SolicitudTraslado>());
        }
        if (transportista.getListaVehiculos() == null) {
            transportista.setListaVehiculos(new ArrayList<Vehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SolicitudTraslado> attachedListaSolicitudes = new ArrayList<SolicitudTraslado>();
            for (SolicitudTraslado listaSolicitudesSolicitudTrasladoToAttach : transportista.getListaSolicitudes()) {
                listaSolicitudesSolicitudTrasladoToAttach = em.getReference(listaSolicitudesSolicitudTrasladoToAttach.getClass(), listaSolicitudesSolicitudTrasladoToAttach.getId());
                attachedListaSolicitudes.add(listaSolicitudesSolicitudTrasladoToAttach);
            }
            transportista.setListaSolicitudes(attachedListaSolicitudes);
            List<Vehiculo> attachedListaVehiculos = new ArrayList<Vehiculo>();
            for (Vehiculo listaVehiculosVehiculoToAttach : transportista.getListaVehiculos()) {
                listaVehiculosVehiculoToAttach = em.getReference(listaVehiculosVehiculoToAttach.getClass(), listaVehiculosVehiculoToAttach.getId());
                attachedListaVehiculos.add(listaVehiculosVehiculoToAttach);
            }
            transportista.setListaVehiculos(attachedListaVehiculos);
            em.persist(transportista);
            for (SolicitudTraslado listaSolicitudesSolicitudTraslado : transportista.getListaSolicitudes()) {
                java.util.List<code.Transportista> oldTransOfListaSolicitudesSolicitudTraslado = listaSolicitudesSolicitudTraslado.getTrans();
                listaSolicitudesSolicitudTraslado.setTrans(transportista);
                listaSolicitudesSolicitudTraslado = em.merge(listaSolicitudesSolicitudTraslado);
                if (oldTransOfListaSolicitudesSolicitudTraslado != null) {
                    oldTransOfListaSolicitudesSolicitudTraslado.getListaSolicitudes().remove(listaSolicitudesSolicitudTraslado);
                    oldTransOfListaSolicitudesSolicitudTraslado = em.merge(oldTransOfListaSolicitudesSolicitudTraslado);
                }
            }
            for (Vehiculo listaVehiculosVehiculo : transportista.getListaVehiculos()) {
                Transportista oldTransOfListaVehiculosVehiculo = listaVehiculosVehiculo.getTrans();
                listaVehiculosVehiculo.setTrans(transportista);
                listaVehiculosVehiculo = em.merge(listaVehiculosVehiculo);
                if (oldTransOfListaVehiculosVehiculo != null) {
                    oldTransOfListaVehiculosVehiculo.getListaVehiculos().remove(listaVehiculosVehiculo);
                    oldTransOfListaVehiculosVehiculo = em.merge(oldTransOfListaVehiculosVehiculo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transportista transportista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transportista persistentTransportista = em.find(Transportista.class, transportista.getId());
            List<SolicitudTraslado> listaSolicitudesOld = persistentTransportista.getListaSolicitudes();
            List<SolicitudTraslado> listaSolicitudesNew = transportista.getListaSolicitudes();
            List<Vehiculo> listaVehiculosOld = persistentTransportista.getListaVehiculos();
            List<Vehiculo> listaVehiculosNew = transportista.getListaVehiculos();
            List<SolicitudTraslado> attachedListaSolicitudesNew = new ArrayList<SolicitudTraslado>();
            for (SolicitudTraslado listaSolicitudesNewSolicitudTrasladoToAttach : listaSolicitudesNew) {
                listaSolicitudesNewSolicitudTrasladoToAttach = em.getReference(listaSolicitudesNewSolicitudTrasladoToAttach.getClass(), listaSolicitudesNewSolicitudTrasladoToAttach.getId());
                attachedListaSolicitudesNew.add(listaSolicitudesNewSolicitudTrasladoToAttach);
            }
            listaSolicitudesNew = attachedListaSolicitudesNew;
            transportista.setListaSolicitudes(listaSolicitudesNew);
            List<Vehiculo> attachedListaVehiculosNew = new ArrayList<Vehiculo>();
            for (Vehiculo listaVehiculosNewVehiculoToAttach : listaVehiculosNew) {
                listaVehiculosNewVehiculoToAttach = em.getReference(listaVehiculosNewVehiculoToAttach.getClass(), listaVehiculosNewVehiculoToAttach.getId());
                attachedListaVehiculosNew.add(listaVehiculosNewVehiculoToAttach);
            }
            listaVehiculosNew = attachedListaVehiculosNew;
            transportista.setListaVehiculos(listaVehiculosNew);
            transportista = em.merge(transportista);
            for (SolicitudTraslado listaSolicitudesOldSolicitudTraslado : listaSolicitudesOld) {
                if (!listaSolicitudesNew.contains(listaSolicitudesOldSolicitudTraslado)) {
                    listaSolicitudesOldSolicitudTraslado.setTrans(null);
                    listaSolicitudesOldSolicitudTraslado = em.merge(listaSolicitudesOldSolicitudTraslado);
                }
            }
            for (SolicitudTraslado listaSolicitudesNewSolicitudTraslado : listaSolicitudesNew) {
                if (!listaSolicitudesOld.contains(listaSolicitudesNewSolicitudTraslado)) {
                    Transportista oldTransOfListaSolicitudesNewSolicitudTraslado = listaSolicitudesNewSolicitudTraslado.getTrans();
                    listaSolicitudesNewSolicitudTraslado.setTrans(transportista);
                    listaSolicitudesNewSolicitudTraslado = em.merge(listaSolicitudesNewSolicitudTraslado);
                    if (oldTransOfListaSolicitudesNewSolicitudTraslado != null && !oldTransOfListaSolicitudesNewSolicitudTraslado.equals(transportista)) {
                        oldTransOfListaSolicitudesNewSolicitudTraslado.getListaSolicitudes().remove(listaSolicitudesNewSolicitudTraslado);
                        oldTransOfListaSolicitudesNewSolicitudTraslado = em.merge(oldTransOfListaSolicitudesNewSolicitudTraslado);
                    }
                }
            }
            for (Vehiculo listaVehiculosOldVehiculo : listaVehiculosOld) {
                if (!listaVehiculosNew.contains(listaVehiculosOldVehiculo)) {
                    listaVehiculosOldVehiculo.setTrans(null);
                    listaVehiculosOldVehiculo = em.merge(listaVehiculosOldVehiculo);
                }
            }
            for (Vehiculo listaVehiculosNewVehiculo : listaVehiculosNew) {
                if (!listaVehiculosOld.contains(listaVehiculosNewVehiculo)) {
                    Transportista oldTransOfListaVehiculosNewVehiculo = listaVehiculosNewVehiculo.getTrans();
                    listaVehiculosNewVehiculo.setTrans(transportista);
                    listaVehiculosNewVehiculo = em.merge(listaVehiculosNewVehiculo);
                    if (oldTransOfListaVehiculosNewVehiculo != null && !oldTransOfListaVehiculosNewVehiculo.equals(transportista)) {
                        oldTransOfListaVehiculosNewVehiculo.getListaVehiculos().remove(listaVehiculosNewVehiculo);
                        oldTransOfListaVehiculosNewVehiculo = em.merge(oldTransOfListaVehiculosNewVehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = transportista.getId();
                if (findTransportista(id) == null) {
                    throw new NonexistentEntityException("The transportista with id " + id + " no longer exists.");
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
            Transportista transportista;
            try {
                transportista = em.getReference(Transportista.class, id);
                transportista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transportista with id " + id + " no longer exists.", enfe);
            }
            List<SolicitudTraslado> listaSolicitudes = transportista.getListaSolicitudes();
            for (SolicitudTraslado listaSolicitudesSolicitudTraslado : listaSolicitudes) {
                listaSolicitudesSolicitudTraslado.setTrans(null);
                listaSolicitudesSolicitudTraslado = em.merge(listaSolicitudesSolicitudTraslado);
            }
            List<Vehiculo> listaVehiculos = transportista.getListaVehiculos();
            for (Vehiculo listaVehiculosVehiculo : listaVehiculos) {
                listaVehiculosVehiculo.setTrans(null);
                listaVehiculosVehiculo = em.merge(listaVehiculosVehiculo);
            }
            em.remove(transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transportista> findTransportistaEntities() {
        return findTransportistaEntities(true, -1, -1);
    }

    public List<Transportista> findTransportistaEntities(int maxResults, int firstResult) {
        return findTransportistaEntities(false, maxResults, firstResult);
    }

    private List<Transportista> findTransportistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transportista.class));
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

    public Transportista findTransportista(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transportista.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransportistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transportista> rt = cq.from(Transportista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
