/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.ProductorModel;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entitys.SolicitudTrasladoModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PRIDE ANACONDA
 */
public class ProductorDAOImp implements IProductorDAO {

    public ProductorDAOImp(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProductorModel create(ProductorModel productorModel) {
        if (productorModel.getListaSolicitudes() == null) {
            productorModel.setListaSolicitudes(new ArrayList<SolicitudTrasladoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SolicitudTrasladoModel> attachedListaSolicitudes = new ArrayList<SolicitudTrasladoModel>();
            for (SolicitudTrasladoModel listaSolicitudesSolicitudTrasladoModelToAttach : productorModel.getListaSolicitudes()) {
                listaSolicitudesSolicitudTrasladoModelToAttach = em.getReference(listaSolicitudesSolicitudTrasladoModelToAttach.getClass(), listaSolicitudesSolicitudTrasladoModelToAttach.getId());
                attachedListaSolicitudes.add(listaSolicitudesSolicitudTrasladoModelToAttach);
            }
            productorModel.setListaSolicitudes(attachedListaSolicitudes);
            em.persist(productorModel);
            for (SolicitudTrasladoModel listaSolicitudesSolicitudTrasladoModel : productorModel.getListaSolicitudes()) {
                ProductorModel oldProdOfListaSolicitudesSolicitudTrasladoModel = listaSolicitudesSolicitudTrasladoModel.getProd();
                listaSolicitudesSolicitudTrasladoModel.setProd(productorModel);
                listaSolicitudesSolicitudTrasladoModel = em.merge(listaSolicitudesSolicitudTrasladoModel);
                if (oldProdOfListaSolicitudesSolicitudTrasladoModel != null) {
                    oldProdOfListaSolicitudesSolicitudTrasladoModel.getListaSolicitudes().remove(listaSolicitudesSolicitudTrasladoModel);
                    oldProdOfListaSolicitudesSolicitudTrasladoModel = em.merge(oldProdOfListaSolicitudesSolicitudTrasladoModel);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productorModel;
    }

    public List<ProductorModel> findProductorModelEntities() {
        return findProductorModelEntities(true, -1, -1);
    }

    public List<ProductorModel> findProductorModelEntities(int maxResults, int firstResult) {
        return findProductorModelEntities(false, maxResults, firstResult);
    }

    private List<ProductorModel> findProductorModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductorModel.class));
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

    public ProductorModel findProductorModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductorModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductorModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductorModel> rt = cq.from(ProductorModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
