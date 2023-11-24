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
import entitys.ProductorModel;
import entitys.ResiduoModel;
import entitys.SolicitudTrasladoModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author marcos_zr
 */
public class SolicitudTrasladoModelJpaController implements Serializable {

    public SolicitudTrasladoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SolicitudTrasladoModel solicitudTrasladoModel) {
        if (solicitudTrasladoModel.getListaResiduos() == null) {
            solicitudTrasladoModel.setListaResiduos(new ArrayList<ResiduoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductorModel prod = solicitudTrasladoModel.getProd();
            if (prod != null) {
                prod = em.getReference(prod.getClass(), prod.getId());
                solicitudTrasladoModel.setProd(prod);
            }
            List<ResiduoModel> attachedListaResiduos = new ArrayList<ResiduoModel>();
            for (ResiduoModel listaResiduosResiduoModelToAttach : solicitudTrasladoModel.getListaResiduos()) {
                listaResiduosResiduoModelToAttach = em.getReference(listaResiduosResiduoModelToAttach.getClass(), listaResiduosResiduoModelToAttach.getId());
                attachedListaResiduos.add(listaResiduosResiduoModelToAttach);
            }
            solicitudTrasladoModel.setListaResiduos(attachedListaResiduos);
            em.persist(solicitudTrasladoModel);
            if (prod != null) {
                prod.getListaSolicitudes().add(solicitudTrasladoModel);
                prod = em.merge(prod);
            }
            for (ResiduoModel listaResiduosResiduoModel : solicitudTrasladoModel.getListaResiduos()) {
                listaResiduosResiduoModel.getListaSolTraslados().add(solicitudTrasladoModel);
                listaResiduosResiduoModel = em.merge(listaResiduosResiduoModel);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SolicitudTrasladoModel solicitudTrasladoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SolicitudTrasladoModel persistentSolicitudTrasladoModel = em.find(SolicitudTrasladoModel.class, solicitudTrasladoModel.getId());
            ProductorModel prodOld = persistentSolicitudTrasladoModel.getProd();
            ProductorModel prodNew = solicitudTrasladoModel.getProd();
            List<ResiduoModel> listaResiduosOld = persistentSolicitudTrasladoModel.getListaResiduos();
            List<ResiduoModel> listaResiduosNew = solicitudTrasladoModel.getListaResiduos();
            if (prodNew != null) {
                prodNew = em.getReference(prodNew.getClass(), prodNew.getId());
                solicitudTrasladoModel.setProd(prodNew);
            }
            List<ResiduoModel> attachedListaResiduosNew = new ArrayList<ResiduoModel>();
            for (ResiduoModel listaResiduosNewResiduoModelToAttach : listaResiduosNew) {
                listaResiduosNewResiduoModelToAttach = em.getReference(listaResiduosNewResiduoModelToAttach.getClass(), listaResiduosNewResiduoModelToAttach.getId());
                attachedListaResiduosNew.add(listaResiduosNewResiduoModelToAttach);
            }
            listaResiduosNew = attachedListaResiduosNew;
            solicitudTrasladoModel.setListaResiduos(listaResiduosNew);
            solicitudTrasladoModel = em.merge(solicitudTrasladoModel);
            if (prodOld != null && !prodOld.equals(prodNew)) {
                prodOld.getListaSolicitudes().remove(solicitudTrasladoModel);
                prodOld = em.merge(prodOld);
            }
            if (prodNew != null && !prodNew.equals(prodOld)) {
                prodNew.getListaSolicitudes().add(solicitudTrasladoModel);
                prodNew = em.merge(prodNew);
            }
            for (ResiduoModel listaResiduosOldResiduoModel : listaResiduosOld) {
                if (!listaResiduosNew.contains(listaResiduosOldResiduoModel)) {
                    listaResiduosOldResiduoModel.getListaSolTraslados().remove(solicitudTrasladoModel);
                    listaResiduosOldResiduoModel = em.merge(listaResiduosOldResiduoModel);
                }
            }
            for (ResiduoModel listaResiduosNewResiduoModel : listaResiduosNew) {
                if (!listaResiduosOld.contains(listaResiduosNewResiduoModel)) {
                    listaResiduosNewResiduoModel.getListaSolTraslados().add(solicitudTrasladoModel);
                    listaResiduosNewResiduoModel = em.merge(listaResiduosNewResiduoModel);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = solicitudTrasladoModel.getId();
                if (findSolicitudTrasladoModel(id) == null) {
                    throw new NonexistentEntityException("The solicitudTrasladoModel with id " + id + " no longer exists.");
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
            SolicitudTrasladoModel solicitudTrasladoModel;
            try {
                solicitudTrasladoModel = em.getReference(SolicitudTrasladoModel.class, id);
                solicitudTrasladoModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitudTrasladoModel with id " + id + " no longer exists.", enfe);
            }
            ProductorModel prod = solicitudTrasladoModel.getProd();
            if (prod != null) {
                prod.getListaSolicitudes().remove(solicitudTrasladoModel);
                prod = em.merge(prod);
            }
            List<ResiduoModel> listaResiduos = solicitudTrasladoModel.getListaResiduos();
            for (ResiduoModel listaResiduosResiduoModel : listaResiduos) {
                listaResiduosResiduoModel.getListaSolTraslados().remove(solicitudTrasladoModel);
                listaResiduosResiduoModel = em.merge(listaResiduosResiduoModel);
            }
            em.remove(solicitudTrasladoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities() {
        return findSolicitudTrasladoModelEntities(true, -1, -1);
    }

    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities(int maxResults, int firstResult) {
        return findSolicitudTrasladoModelEntities(false, maxResults, firstResult);
    }

    private List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SolicitudTrasladoModel.class));
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

    public SolicitudTrasladoModel findSolicitudTrasladoModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitudTrasladoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitudTrasladoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SolicitudTrasladoModel> rt = cq.from(SolicitudTrasladoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
