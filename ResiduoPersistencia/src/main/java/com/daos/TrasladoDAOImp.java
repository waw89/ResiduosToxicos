/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.TrasladoModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Implementación de la interfaz ITrasladoDAO que define las operaciones de acceso a datos
 * para la entidad TrasladoModel.
 *
 * @author PRIDE ANACONDA
 */
public class TrasladoDAOImp implements ITrasladoDAO {

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
     * Crea y persiste una nueva entidad de traslado en la base de datos.
     *
     * @param trasladoModel Objeto TrasladoModel a ser creado y persistido.
     * @return Objeto TrasladoModel creado y almacenado en la base de datos.
     */
    @Override
    public TrasladoModel create(TrasladoModel trasladoModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trasladoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return trasladoModel;
    }

    /**
     * Obtiene una lista de todos los traslados almacenados en la base de datos.
     *
     * @return Lista de objetos TrasladoModel.
     */
    @Override
    public List<TrasladoModel> findTrasladoModelEntities() {
        return findTrasladoModelEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista paginada de traslados almacenados en la base de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos TrasladoModel.
     */
    @Override
    public List<TrasladoModel> findTrasladoModelEntities(int maxResults, int firstResult) {
        return findTrasladoModelEntities(false, maxResults, firstResult);
    }

    private List<TrasladoModel> findTrasladoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrasladoModel.class));
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
     * Busca y devuelve un traslado basado en su identificador único.
     *
     * @param id Identificador único del traslado a buscar.
     * @return Objeto TrasladoModel encontrado o null si no se encuentra.
     */
    @Override
    public TrasladoModel findTrasladoModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrasladoModel.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene la cantidad total de traslados almacenados en la base de datos.
     *
     * @return Cantidad total de traslados.
     */
    @Override
    public int getTrasladoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrasladoModel> rt = cq.from(TrasladoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
