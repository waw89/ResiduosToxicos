/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Solicitud_Transportista;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Implementación de la interfaz ISolicitudTransportistaDAO para la entidad
 * Solicitud_Transportista. 
 * @author marcos_zr
 */
public class Solicitud_TransportistaDAOImp implements ISolicitudTransportistaDAO {

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
     * Crea y persiste una nueva solicitud de transportista en la base de datos.
     *
     * @param solicitud_Transportista Objeto Solicitud_Transportista a ser
     * creado y persistido.
     */
    public void create(Solicitud_Transportista solicitud_Transportista) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(solicitud_Transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edita y actualiza la información de una solicitud de transportista en la
     * base de datos.
     *
     * @param solicitud_Transportista Objeto Solicitud_Transportista a ser
     * actualizado.
     * @throws NonexistentEntityException Si la entidad no existe en la base de
     * datos.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    @Override
    public void edit(Solicitud_Transportista solicitud_Transportista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            solicitud_Transportista = em.merge(solicitud_Transportista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = solicitud_Transportista.getId();
                if (findSolicitud_Transportista(id) == null) {
                    throw new NonexistentEntityException("The solicitud_Transportista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina una solicitud de transportista de la base de datos.
     *
     * @param id Identificador único de la solicitud de transportista a ser
     * eliminada.
     * @throws NonexistentEntityException Si la entidad no existe en la base de
     * datos.
     */
    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitud_Transportista solicitud_Transportista;
            try {
                solicitud_Transportista = em.getReference(Solicitud_Transportista.class, id);
                solicitud_Transportista.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitud_Transportista with id " + id + " no longer exists.", enfe);
            }
            em.remove(solicitud_Transportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Obtiene una lista de todas las solicitudes de transportista almacenadas
     * en la base de datos.
     *
     * @return Lista de objetos Solicitud_Transportista.
     */
    @Override
    public List<Solicitud_Transportista> findSolicitud_TransportistaEntities() {
        return findSolicitud_TransportistaEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista paginada de solicitudes de transportista almacenadas en
     * la base de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos Solicitud_Transportista.
     */
    @Override
    public List<Solicitud_Transportista> findSolicitud_TransportistaEntities(int maxResults, int firstResult) {
        return findSolicitud_TransportistaEntities(false, maxResults, firstResult);
    }

    private List<Solicitud_Transportista> findSolicitud_TransportistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Solicitud_Transportista.class));
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
     * Busca y devuelve una solicitud de transportista basada en su
     * identificador único.
     *
     * @param id Identificador único de la solicitud de transportista a buscar.
     * @return Objeto Solicitud_Transportista encontrado o null si no se
     * encuentra.
     */
    @Override
    public Solicitud_Transportista findSolicitud_Transportista(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Solicitud_Transportista.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene la cantidad total de solicitudes de transportista almacenadas en
     * la base de datos.
     *
     * @return Cantidad total de solicitudes de transportista.
     */
    @Override
    public int getSolicitud_TransportistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Solicitud_Transportista> rt = cq.from(Solicitud_Transportista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
