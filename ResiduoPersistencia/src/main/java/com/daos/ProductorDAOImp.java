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

    /**
     * Definición del patrón Singleton
     */
    private EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    /**
     * Metodo que establace la conexión a la base de datos utilizando el patrón
     * Singleton
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

/**
     * Metodo que crea registros en la tabla prodcutor
     *
     * @param productorModel
     * @return productorModel
     */
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

      /**
     * Metodo que busca todos los registros de la tabla productor en la base de
     * datos
     *
     * @return lista de productores
     */
    @Override
    public List<ProductorModel> findProductorModelEntities() {
        return findProductorModelEntities(true, -1, -1);
    }

      /**
     * Metodo que busca todos los registros de la tabla productor en la base de
     * datos
     *
     * @param maxResults
     * @param firstResult
     * @return lista de productores
     */
    @Override
    public List<ProductorModel> findProductorModelEntities(int maxResults, int firstResult) {
        return findProductorModelEntities(false, maxResults, firstResult);
    }

     /**
     * Metodo que busca en los registros de la tabla productor en la base de
     * datos
     *
     * @param all 
     * @param firstResult 
     * @param maxResults 
     * @return Lista de productores
     */
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

    /**
     * Metodo que busca en los registros de la tabla productor en la base de
     * datos en base a su id
     *
     * @param id
     * @return productor encontrado
     */
    @Override
    public ProductorModel findProductorModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductorModel.class, id);
        } finally {
            em.close();
        }
    }

     /**
     * Obtiene el numero de registros de la tabla productor
     *
     * @return numero de registros
     */
    
    @Override
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
