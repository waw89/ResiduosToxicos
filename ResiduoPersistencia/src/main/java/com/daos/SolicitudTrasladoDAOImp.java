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
 * Implementación de la interfaz ISolicitudTrasladoDAO que define las
 * operaciones de acceso a datos para la entidad SolicitudTrasladoModel.
 *
 * @author  PRIDE ANACONDA
 */
public class SolicitudTrasladoDAOImp implements ISolicitudTrasladoDAO {

    private EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    /**
     * Método para obtener una instancia de EntityManager.
     *
     * @return EntityManager.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Crea y persiste una nueva solicitud de traslado en la base de datos.
     *
     * @param solicitudTrasladoModel Objeto SolicitudTrasladoModel a ser creado
     * y persistido.
     * @return Objeto SolicitudTrasladoModel creado y almacenado en la base de
     * datos.
     */
    @Override
    public SolicitudTrasladoModel create(SolicitudTrasladoModel solicitudTrasladoModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Lógica para asociar entidades y persistir la solicitud de traslado.
            // ...
            em.persist(solicitudTrasladoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return solicitudTrasladoModel;
    }

    /**
     * Actualiza la información de una solicitud de traslado en la base de
     * datos.
     *
     * @param solicitudTrasladoModel Objeto SolicitudTrasladoModel a ser
     * actualizado.
     * @return Objeto SolicitudTrasladoModel actualizado en la base de datos.
     */
    @Override
    public SolicitudTrasladoModel update(SolicitudTrasladoModel solicitudTrasladoModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Lógica para actualizar la solicitud de traslado.
            // ...
            em.merge(solicitudTrasladoModel);
            em.getTransaction().commit();

            return solicitudTrasladoModel;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Obtiene una lista de todas las solicitudes de traslado almacenadas en la
     * base de datos.
     *
     * @return Lista de objetos SolicitudTrasladoModel.
     */
    @Override
    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities() {
        return findSolicitudTrasladoModelEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista paginada de solicitudes de traslado almacenadas en la
     * base de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos SolicitudTrasladoModel.
     */
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

    /**
     * Busca y devuelve una solicitud de traslado basada en su identificador
     * único.
     *
     * @param id Identificador único de la solicitud de traslado a buscar.
     * @return Objeto SolicitudTrasladoModel encontrado o null si no se
     * encuentra.
     */
    @Override
    public SolicitudTrasladoModel findSolicitudTrasladoModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SolicitudTrasladoModel.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene la cantidad total de solicitudes de traslado almacenadas en la
     * base de datos.
     *
     * @return Cantidad total de solicitudes de traslado.
     */
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
     * Carga una lista de solicitudes de traslado en la base de datos.
     *
     * @param solicitudes Lista de objetos SolicitudTrasladoModel a ser cargada
     * en la base de datos.
     * @return Lista de objetos SolicitudTrasladoModel actualizada.
     */
    @Override
    public List<SolicitudTrasladoModel> cargaSolicitudes(List<SolicitudTrasladoModel> solicitudes) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (verificaSolicitudes()) {
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
     * Verifica la existencia de solicitudes de traslado en la base de datos.
     *
     * @return true si existen solicitudes de traslado, false si no existen.
     */
    public boolean verificaSolicitudes() {
        return findSolicitudTrasladoModelEntities().isEmpty();
    }
}
