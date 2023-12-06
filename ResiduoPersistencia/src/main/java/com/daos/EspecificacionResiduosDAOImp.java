/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Especificacion_Residuos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que representa el DAO de la tabla asociación "Solicitud_Residuo"
 *
 * @author PRIDE ANACONDA
 */
public class EspecificacionResiduosDAOImp implements IEspecificacionDAO {

    /**
     * Metodo constructor por omisión
     */
    public EspecificacionResiduosDAOImp() {

    }

    /**
     * Definición del patrón Singleton
     */
    private EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    /**
     * Metodo que establace la conexión a la base de datos utilizando el patrón
     * Singleton
     *
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Metodo que se encarga de editar los registros de la tabla
     * "Solicitud_Traslado"
     *
     * @param especificacion_Residuos
     * @throws NonexistentEntityException
     * @throws Exception
     */
    @Override
    public void edit(Especificacion_Residuos especificacion_Residuos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            especificacion_Residuos = em.merge(especificacion_Residuos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = especificacion_Residuos.getId();
                if (findEspecificacion_Residuos(id) == null) {
                    throw new NonexistentEntityException("The especificacion_Residuos with id " + id + " no longer exists.");
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
     * Metodo que se encarga de eliminar un registro de la tabla
     * "Solicitud_Traslado"
     *
     * @param id
     * @throws NonexistentEntityException
     */
    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especificacion_Residuos especificacion_Residuos;
            try {
                especificacion_Residuos = em.getReference(Especificacion_Residuos.class, id);
                especificacion_Residuos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especificacion_Residuos with id " + id + " no longer exists.", enfe);
            }
            em.remove(especificacion_Residuos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Metodo que busca los registros de la base de datos
     *
     * @return lista de especificacion de residuos
     */
    @Override
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities() {
        return findEspecificacion_ResiduosEntities(true, -1, -1);
    }

    /**
     * Metodo que busca los registros de la base de datos
     *
     * @param maxResults
     * @param firstResult
     * @return lista de especificacion de residuos
     */
    @Override
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(int maxResults, int firstResult) {
        return findEspecificacion_ResiduosEntities(false, maxResults, firstResult);
    }

    /**
     * Metodo que busca los registros de la base de datos
     *
     * @param all
     * @param maxResults
     * @param firstResult
     * @return lista de especificacion de residuos
     */
    @Override
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especificacion_Residuos.class));
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
     * Metodo que busca la especificacion de residuos en la base de datos por su
     * id
     *
     * @param id
     * @return Especificacion de residuos
     */
    @Override
    public Especificacion_Residuos findEspecificacion_Residuos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especificacion_Residuos.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que obtiene el numero de registros que hay en la base de datos
     *
     * @return numero de registros
     */
    @Override
    public int getEspecificacion_ResiduosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especificacion_Residuos> rt = cq.from(Especificacion_Residuos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
