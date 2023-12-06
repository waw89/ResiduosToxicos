/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.AdministradorModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase DAO del AdministradorModel que implementa la interfaz IAdministradorDAO
 *
 * @author PRIDE ANACONDA
 */
public class AdministradorDAOImp implements IAdministradorDAO {

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
     * Metodo que crea un Administrador en la base de datos
     *
     * @param administradorModel
     * @return administradorModel
     */
    @Override
    public AdministradorModel create(AdministradorModel administradorModel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(administradorModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return administradorModel;
    }

    /**
     * Metodo que busca todos los registros en la base de datos
     *
     * @return lista de administradores
     */
    @Override
    public List<AdministradorModel> findAdministradorModelEntities() {
        return findAdministradorModelEntities(true, -1, -1);
    }

    /**
     * Metodo que busca todos los registros en la base de datos
     *
     * @param maxResults
     * @param firstResult
     * @return lista de administradores
     */
    @Override
    public List<AdministradorModel> findAdministradorModelEntities(int maxResults, int firstResult) {
        return findAdministradorModelEntities(false, maxResults, firstResult);
    }

    /**
     * Metodo que busca todos los registros en la base de datos
     *
     * @param all
     * @param maxResults
     * @param firstResult
     * @return lista de administradores
     */
    private List<AdministradorModel> findAdministradorModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AdministradorModel.class));
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
     * Metodo que busca los registros de administrador en la base de datos por
     * su id
     *
     * @param id
     * @return AdministradorModel
     */
    @Override
    public AdministradorModel findAdministradorModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AdministradorModel.class, id);
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
    public int getAdministradorModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AdministradorModel> rt = cq.from(AdministradorModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
