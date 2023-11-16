/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daosimp;

import code.SolicitudTraslado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import code.Transportista;
import com.entitycontrollers.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author xxbry
 */
public class SolicitudTrasladoDAOImp implements Serializable {

    public SolicitudTrasladoDAOImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolicitudTraslado solicitudTraslado) {
        if (solicitudTraslado.getTrans() == null) {
            solicitudTraslado.setTrans(new ArrayList<Transportista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Transportista> attachedTrans = new ArrayList<Transportista>();
            for (Transportista transTransportistaToAttach : solicitudTraslado.getTrans()) {
                transTransportistaToAttach = em.getReference(transTransportistaToAttach.getClass(), transTransportistaToAttach.getId());
                attachedTrans.add(transTransportistaToAttach);
            }
            solicitudTraslado.setTrans(attachedTrans);
            em.persist(solicitudTraslado);
            for (Transportista transTransportista : solicitudTraslado.getTrans()) {
                transTransportista.getListaSolicitudes().add(solicitudTraslado);
                transTransportista = em.merge(transTransportista);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolicitudTraslado solicitudTraslado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudTraslado persistentSolicitudTraslado = em.find(SolicitudTraslado.class, solicitudTraslado.getId());
            List<Transportista> transOld = persistentSolicitudTraslado.getTrans();
            List<Transportista> transNew = solicitudTraslado.getTrans();
            List<Transportista> attachedTransNew = new ArrayList<Transportista>();
            for (Transportista transNewTransportistaToAttach : transNew) {
                transNewTransportistaToAttach = em.getReference(transNewTransportistaToAttach.getClass(), transNewTransportistaToAttach.getId());
                attachedTransNew.add(transNewTransportistaToAttach);
            }
            transNew = attachedTransNew;
            solicitudTraslado.setTrans(transNew);
            solicitudTraslado = em.merge(solicitudTraslado);
            for (Transportista transOldTransportista : transOld) {
                if (!transNew.contains(transOldTransportista)) {
                    transOldTransportista.getListaSolicitudes().remove(solicitudTraslado);
                    transOldTransportista = em.merge(transOldTransportista);
                }
            }
            for (Transportista transNewTransportista : transNew) {
                if (!transOld.contains(transNewTransportista)) {
                    transNewTransportista.getListaSolicitudes().add(solicitudTraslado);
                    transNewTransportista = em.merge(transNewTransportista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = solicitudTraslado.getId();
                if (findSolicitudTraslado(id) == null) {
                    throw new NonexistentEntityException("The solicitudTraslado with id " + id + " no longer exists.");
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
            SolicitudTraslado solicitudTraslado;
            try {
                solicitudTraslado = em.getReference(SolicitudTraslado.class, id);
                solicitudTraslado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitudTraslado with id " + id + " no longer exists.", enfe);
            }
            List<Transportista> trans = solicitudTraslado.getTrans();
            for (Transportista transTransportista : trans) {
                transTransportista.getListaSolicitudes().remove(solicitudTraslado);
                transTransportista = em.merge(transTransportista);
            }
            em.remove(solicitudTraslado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitudTraslado> findSolicitudTrasladoEntities() {
        return findSolicitudTrasladoEntities(true, -1, -1);
    }

    public List<SolicitudTraslado> findSolicitudTrasladoEntities(int maxResults, int firstResult) {
        return findSolicitudTrasladoEntities(false, maxResults, firstResult);
    }

    private List<SolicitudTraslado> findSolicitudTrasladoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolicitudTraslado.class));
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

    public SolicitudTraslado findSolicitudTraslado(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitudTraslado.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitudTrasladoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolicitudTraslado> rt = cq.from(SolicitudTraslado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
