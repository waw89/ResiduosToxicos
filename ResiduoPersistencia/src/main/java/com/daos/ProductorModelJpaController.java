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
public class ProductorModelJpaController implements Serializable {

    public ProductorModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductorModel productorModel) {
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
    }

    public void edit(ProductorModel productorModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductorModel persistentProductorModel = em.find(ProductorModel.class, productorModel.getId());
            List<SolicitudTrasladoModel> listaSolicitudesOld = persistentProductorModel.getListaSolicitudes();
            List<SolicitudTrasladoModel> listaSolicitudesNew = productorModel.getListaSolicitudes();
            List<SolicitudTrasladoModel> attachedListaSolicitudesNew = new ArrayList<SolicitudTrasladoModel>();
            for (SolicitudTrasladoModel listaSolicitudesNewSolicitudTrasladoModelToAttach : listaSolicitudesNew) {
                listaSolicitudesNewSolicitudTrasladoModelToAttach = em.getReference(listaSolicitudesNewSolicitudTrasladoModelToAttach.getClass(), listaSolicitudesNewSolicitudTrasladoModelToAttach.getId());
                attachedListaSolicitudesNew.add(listaSolicitudesNewSolicitudTrasladoModelToAttach);
            }
            listaSolicitudesNew = attachedListaSolicitudesNew;
            productorModel.setListaSolicitudes(listaSolicitudesNew);
            productorModel = em.merge(productorModel);
            for (SolicitudTrasladoModel listaSolicitudesOldSolicitudTrasladoModel : listaSolicitudesOld) {
                if (!listaSolicitudesNew.contains(listaSolicitudesOldSolicitudTrasladoModel)) {
                    listaSolicitudesOldSolicitudTrasladoModel.setProd(null);
                    listaSolicitudesOldSolicitudTrasladoModel = em.merge(listaSolicitudesOldSolicitudTrasladoModel);
                }
            }
            for (SolicitudTrasladoModel listaSolicitudesNewSolicitudTrasladoModel : listaSolicitudesNew) {
                if (!listaSolicitudesOld.contains(listaSolicitudesNewSolicitudTrasladoModel)) {
                    ProductorModel oldProdOfListaSolicitudesNewSolicitudTrasladoModel = listaSolicitudesNewSolicitudTrasladoModel.getProd();
                    listaSolicitudesNewSolicitudTrasladoModel.setProd(productorModel);
                    listaSolicitudesNewSolicitudTrasladoModel = em.merge(listaSolicitudesNewSolicitudTrasladoModel);
                    if (oldProdOfListaSolicitudesNewSolicitudTrasladoModel != null && !oldProdOfListaSolicitudesNewSolicitudTrasladoModel.equals(productorModel)) {
                        oldProdOfListaSolicitudesNewSolicitudTrasladoModel.getListaSolicitudes().remove(listaSolicitudesNewSolicitudTrasladoModel);
                        oldProdOfListaSolicitudesNewSolicitudTrasladoModel = em.merge(oldProdOfListaSolicitudesNewSolicitudTrasladoModel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = productorModel.getId();
                if (findProductorModel(id) == null) {
                    throw new NonexistentEntityException("The productorModel with id " + id + " no longer exists.");
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
            ProductorModel productorModel;
            try {
                productorModel = em.getReference(ProductorModel.class, id);
                productorModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productorModel with id " + id + " no longer exists.", enfe);
            }
            List<SolicitudTrasladoModel> listaSolicitudes = productorModel.getListaSolicitudes();
            for (SolicitudTrasladoModel listaSolicitudesSolicitudTrasladoModel : listaSolicitudes) {
                listaSolicitudesSolicitudTrasladoModel.setProd(null);
                listaSolicitudesSolicitudTrasladoModel = em.merge(listaSolicitudesSolicitudTrasladoModel);
            }
            em.remove(productorModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
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
