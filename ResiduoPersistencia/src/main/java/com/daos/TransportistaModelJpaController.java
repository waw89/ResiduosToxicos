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
import entitys.SolicitudTrasladoModel;
import entitys.TransportistaModel;
import java.util.ArrayList;
import java.util.List;
import entitys.VehiculoModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PRIDE ANACONDA
 */
public class TransportistaModelJpaController implements Serializable {

    public TransportistaModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TransportistaModel transportistaModel) {
        if (transportistaModel.getListaSolicitudes() == null) {
            transportistaModel.setListaSolicitudes(new ArrayList<SolicitudTrasladoModel>());
        }
        if (transportistaModel.getListaVehiculos() == null) {
            transportistaModel.setListaVehiculos(new ArrayList<VehiculoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SolicitudTrasladoModel> attachedListaSolicitudes = new ArrayList<SolicitudTrasladoModel>();
            for (SolicitudTrasladoModel listaSolicitudesSolicitudTrasladoModelToAttach : transportistaModel.getListaSolicitudes()) {
                listaSolicitudesSolicitudTrasladoModelToAttach = em.getReference(listaSolicitudesSolicitudTrasladoModelToAttach.getClass(), listaSolicitudesSolicitudTrasladoModelToAttach.getId());
                attachedListaSolicitudes.add(listaSolicitudesSolicitudTrasladoModelToAttach);
            }
            transportistaModel.setListaSolicitudes(attachedListaSolicitudes);
            List<VehiculoModel> attachedListaVehiculos = new ArrayList<VehiculoModel>();
            for (VehiculoModel listaVehiculosVehiculoModelToAttach : transportistaModel.getListaVehiculos()) {
                listaVehiculosVehiculoModelToAttach = em.getReference(listaVehiculosVehiculoModelToAttach.getClass(), listaVehiculosVehiculoModelToAttach.getId());
                attachedListaVehiculos.add(listaVehiculosVehiculoModelToAttach);
            }
            transportistaModel.setListaVehiculos(attachedListaVehiculos);
            em.persist(transportistaModel);
            for (SolicitudTrasladoModel listaSolicitudesSolicitudTrasladoModel : transportistaModel.getListaSolicitudes()) {
                java.util.List<entitys.TransportistaModel> oldTransOfListaSolicitudesSolicitudTrasladoModel = listaSolicitudesSolicitudTrasladoModel.getTrans();
                listaSolicitudesSolicitudTrasladoModel.setTrans(transportistaModel);
                listaSolicitudesSolicitudTrasladoModel = em.merge(listaSolicitudesSolicitudTrasladoModel);
                if (oldTransOfListaSolicitudesSolicitudTrasladoModel != null) {
                    oldTransOfListaSolicitudesSolicitudTrasladoModel.getListaSolicitudes().remove(listaSolicitudesSolicitudTrasladoModel);
                    oldTransOfListaSolicitudesSolicitudTrasladoModel = em.merge(oldTransOfListaSolicitudesSolicitudTrasladoModel);
                }
            }
            for (VehiculoModel listaVehiculosVehiculoModel : transportistaModel.getListaVehiculos()) {
                TransportistaModel oldTransOfListaVehiculosVehiculoModel = listaVehiculosVehiculoModel.getTrans();
                listaVehiculosVehiculoModel.setTrans(transportistaModel);
                listaVehiculosVehiculoModel = em.merge(listaVehiculosVehiculoModel);
                if (oldTransOfListaVehiculosVehiculoModel != null) {
                    oldTransOfListaVehiculosVehiculoModel.getListaVehiculos().remove(listaVehiculosVehiculoModel);
                    oldTransOfListaVehiculosVehiculoModel = em.merge(oldTransOfListaVehiculosVehiculoModel);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TransportistaModel transportistaModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TransportistaModel persistentTransportistaModel = em.find(TransportistaModel.class, transportistaModel.getId());
            List<SolicitudTrasladoModel> listaSolicitudesOld = persistentTransportistaModel.getListaSolicitudes();
            List<SolicitudTrasladoModel> listaSolicitudesNew = transportistaModel.getListaSolicitudes();
            List<VehiculoModel> listaVehiculosOld = persistentTransportistaModel.getListaVehiculos();
            List<VehiculoModel> listaVehiculosNew = transportistaModel.getListaVehiculos();
            List<SolicitudTrasladoModel> attachedListaSolicitudesNew = new ArrayList<SolicitudTrasladoModel>();
            for (SolicitudTrasladoModel listaSolicitudesNewSolicitudTrasladoModelToAttach : listaSolicitudesNew) {
                listaSolicitudesNewSolicitudTrasladoModelToAttach = em.getReference(listaSolicitudesNewSolicitudTrasladoModelToAttach.getClass(), listaSolicitudesNewSolicitudTrasladoModelToAttach.getId());
                attachedListaSolicitudesNew.add(listaSolicitudesNewSolicitudTrasladoModelToAttach);
            }
            listaSolicitudesNew = attachedListaSolicitudesNew;
            transportistaModel.setListaSolicitudes(listaSolicitudesNew);
            List<VehiculoModel> attachedListaVehiculosNew = new ArrayList<VehiculoModel>();
            for (VehiculoModel listaVehiculosNewVehiculoModelToAttach : listaVehiculosNew) {
                listaVehiculosNewVehiculoModelToAttach = em.getReference(listaVehiculosNewVehiculoModelToAttach.getClass(), listaVehiculosNewVehiculoModelToAttach.getId());
                attachedListaVehiculosNew.add(listaVehiculosNewVehiculoModelToAttach);
            }
            listaVehiculosNew = attachedListaVehiculosNew;
            transportistaModel.setListaVehiculos(listaVehiculosNew);
            transportistaModel = em.merge(transportistaModel);
            for (SolicitudTrasladoModel listaSolicitudesOldSolicitudTrasladoModel : listaSolicitudesOld) {
                if (!listaSolicitudesNew.contains(listaSolicitudesOldSolicitudTrasladoModel)) {
                    listaSolicitudesOldSolicitudTrasladoModel.setTrans(null);
                    listaSolicitudesOldSolicitudTrasladoModel = em.merge(listaSolicitudesOldSolicitudTrasladoModel);
                }
            }
            for (SolicitudTrasladoModel listaSolicitudesNewSolicitudTrasladoModel : listaSolicitudesNew) {
                if (!listaSolicitudesOld.contains(listaSolicitudesNewSolicitudTrasladoModel)) {
                    TransportistaModel oldTransOfListaSolicitudesNewSolicitudTrasladoModel = listaSolicitudesNewSolicitudTrasladoModel.getTrans();
                    listaSolicitudesNewSolicitudTrasladoModel.setTrans(transportistaModel);
                    listaSolicitudesNewSolicitudTrasladoModel = em.merge(listaSolicitudesNewSolicitudTrasladoModel);
                    if (oldTransOfListaSolicitudesNewSolicitudTrasladoModel != null && !oldTransOfListaSolicitudesNewSolicitudTrasladoModel.equals(transportistaModel)) {
                        oldTransOfListaSolicitudesNewSolicitudTrasladoModel.getListaSolicitudes().remove(listaSolicitudesNewSolicitudTrasladoModel);
                        oldTransOfListaSolicitudesNewSolicitudTrasladoModel = em.merge(oldTransOfListaSolicitudesNewSolicitudTrasladoModel);
                    }
                }
            }
            for (VehiculoModel listaVehiculosOldVehiculoModel : listaVehiculosOld) {
                if (!listaVehiculosNew.contains(listaVehiculosOldVehiculoModel)) {
                    listaVehiculosOldVehiculoModel.setTrans(null);
                    listaVehiculosOldVehiculoModel = em.merge(listaVehiculosOldVehiculoModel);
                }
            }
            for (VehiculoModel listaVehiculosNewVehiculoModel : listaVehiculosNew) {
                if (!listaVehiculosOld.contains(listaVehiculosNewVehiculoModel)) {
                    TransportistaModel oldTransOfListaVehiculosNewVehiculoModel = listaVehiculosNewVehiculoModel.getTrans();
                    listaVehiculosNewVehiculoModel.setTrans(transportistaModel);
                    listaVehiculosNewVehiculoModel = em.merge(listaVehiculosNewVehiculoModel);
                    if (oldTransOfListaVehiculosNewVehiculoModel != null && !oldTransOfListaVehiculosNewVehiculoModel.equals(transportistaModel)) {
                        oldTransOfListaVehiculosNewVehiculoModel.getListaVehiculos().remove(listaVehiculosNewVehiculoModel);
                        oldTransOfListaVehiculosNewVehiculoModel = em.merge(oldTransOfListaVehiculosNewVehiculoModel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = transportistaModel.getId();
                if (findTransportistaModel(id) == null) {
                    throw new NonexistentEntityException("The transportistaModel with id " + id + " no longer exists.");
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
            TransportistaModel transportistaModel;
            try {
                transportistaModel = em.getReference(TransportistaModel.class, id);
                transportistaModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transportistaModel with id " + id + " no longer exists.", enfe);
            }
            List<SolicitudTrasladoModel> listaSolicitudes = transportistaModel.getListaSolicitudes();
            for (SolicitudTrasladoModel listaSolicitudesSolicitudTrasladoModel : listaSolicitudes) {
                listaSolicitudesSolicitudTrasladoModel.setTrans(null);
                listaSolicitudesSolicitudTrasladoModel = em.merge(listaSolicitudesSolicitudTrasladoModel);
            }
            List<VehiculoModel> listaVehiculos = transportistaModel.getListaVehiculos();
            for (VehiculoModel listaVehiculosVehiculoModel : listaVehiculos) {
                listaVehiculosVehiculoModel.setTrans(null);
                listaVehiculosVehiculoModel = em.merge(listaVehiculosVehiculoModel);
            }
            em.remove(transportistaModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TransportistaModel> findTransportistaModelEntities() {
        return findTransportistaModelEntities(true, -1, -1);
    }

    public List<TransportistaModel> findTransportistaModelEntities(int maxResults, int firstResult) {
        return findTransportistaModelEntities(false, maxResults, firstResult);
    }

    private List<TransportistaModel> findTransportistaModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TransportistaModel.class));
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

    public TransportistaModel findTransportistaModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TransportistaModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransportistaModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TransportistaModel> rt = cq.from(TransportistaModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
