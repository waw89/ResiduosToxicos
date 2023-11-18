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
import java.util.ArrayList;
import java.util.List;
import entitys.ProductorModel;
import entitys.ResiduoModel;
import entitys.SolicitudTrasladoModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PRIDE ANACONDA
 */
public class SolicitudTrasladoDAOImp implements ISolicitudTrasladoDAO {

    public SolicitudTrasladoDAOImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SolicitudTrasladoModel create(SolicitudTrasladoModel solicitudTrasladoModel) {
        if (solicitudTrasladoModel.getTrans() == null) {
            solicitudTrasladoModel.setTrans(new ArrayList<TransportistaModel>());
        }
        if (solicitudTrasladoModel.getListaResiduos() == null) {
            solicitudTrasladoModel.setListaResiduos(new ArrayList<ResiduoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TransportistaModel> attachedTrans = new ArrayList<TransportistaModel>();
            for (TransportistaModel transTransportistaModelToAttach : solicitudTrasladoModel.getTrans()) {
                transTransportistaModelToAttach = em.getReference(transTransportistaModelToAttach.getClass(), transTransportistaModelToAttach.getId());
                attachedTrans.add(transTransportistaModelToAttach);
            }
            solicitudTrasladoModel.setTrans(attachedTrans);
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
            for (TransportistaModel transTransportistaModel : solicitudTrasladoModel.getTrans()) {
                transTransportistaModel.getListaSolicitudes().add(solicitudTrasladoModel);
                transTransportistaModel = em.merge(transTransportistaModel);
            }
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
        
        return solicitudTrasladoModel;
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
