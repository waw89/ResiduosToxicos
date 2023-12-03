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
import javax.persistence.EntityTransaction;

/**
 *
 * @author PRIDE ANACONDA
 */
public class SolicitudTrasladoDAOImp implements ISolicitudTrasladoDAO {

    public SolicitudTrasladoDAOImp() {
        
    }
    EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public SolicitudTrasladoModel create(SolicitudTrasladoModel solicitudTrasladoModel) {
        
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
        
        return solicitudTrasladoModel;
    }

    /**
     * Método update que actualiza la solicitud de traslado en la base de datos 
     * @param solicitudTrasladoModel la solicitud de traslado a actualizar
     * @return la solicitud de traslado actualizada
     */
    @Override
    public SolicitudTrasladoModel update(SolicitudTrasladoModel solicitudTrasladoModel){
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Cargar la entidad desde la base de datos
            SolicitudTrasladoModel persistentSolicitud = em.find(SolicitudTrasladoModel.class, solicitudTrasladoModel.getId());

            // Actualizar los campos de la entidad cargada con los valores del parámetro
            persistentSolicitud.setFecha(solicitudTrasladoModel.getFecha());
            persistentSolicitud.setAsignado(solicitudTrasladoModel.esAsignado());
            persistentSolicitud.setProd(solicitudTrasladoModel.getProd());
            // Actualizar la lista de residuos (puedes necesitar una lógica más compleja dependiendo de tus necesidades)
            persistentSolicitud.setListaResiduos(solicitudTrasladoModel.getListaResiduos());
            //Actualizar la lista de empresas transportistas, versión preeliminar
            persistentSolicitud.setTransportistas(solicitudTrasladoModel.getTransportistas());
            // Puedes necesitar manejar las relaciones bidireccionales aquí si es necesario
            // Realizar la operación de actualización
            em.merge(persistentSolicitud);

            em.getTransaction().commit();

            return persistentSolicitud;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities() {
        return findSolicitudTrasladoModelEntities(true, -1, -1);
    }

    @Override
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

    @Override
    public SolicitudTrasladoModel findSolicitudTrasladoModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitudTrasladoModel.class, id);
        } finally {
            em.close();
        }
    }

    @Override
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
    
    /**
     * Método cargaSolicitudes que regresa la lista de solicitudes de traslado
     * desde la base de datos
     * @param solicitudes la lista de solicitudes que se regresará
     * @return lista de solicitudes de traslado
     */
    @Override
    public List<SolicitudTrasladoModel> cargaSolicitudes(List<SolicitudTrasladoModel> solicitudes){
        
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            if (verificaSolicitudes()== true) {
                for (SolicitudTrasladoModel solicitud : solicitudes) {
                    em.persist(solicitud);
                }

                transaction.commit();
            } else {
                return findSolicitudTrasladoModelEntities();
            }

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Puedes manejar la excepción o relanzarla según tus necesidades
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return solicitudes;
    }
    
    /**
     * Método verificaSolicitudes que regresa true en caso de encontrar solicitudes de traslado en la base 
     * de datos, false caso contrario
     * @return true en caso de encontrar solicitudes de traslado, false caso contrario
     */
    public boolean verificaSolicitudes() {
  
        if (findSolicitudTrasladoModelEntities().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
