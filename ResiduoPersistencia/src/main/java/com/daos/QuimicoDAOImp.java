/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import entitys.QuimicoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase que representa la capa DAO del Quimico
 * @author xxbry
 */
public class QuimicoDAOImp implements IQuimicoDAO {

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
     * Metodo que crea un objeto QuimicoModel en la base de datos
     *
     * @param quimico
     */
    @Override
    public void create(QuimicoModel quimico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(quimico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Metodo que verifica si la lista de quimicos está vacía
     *
     * @return true/false
     */
    @Override
    public boolean verificaQuimicos() {

        if (findQuimicoEntities().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Llena una lista de objetos QuimicoModel con la información proporcionada.
     *
     * @param quimicos Lista de objetos QuimicoModel a ser llenada.
     * @return Lista de objetos QuimicoModel actualizada.
     */
    @Override
    public List<QuimicoModel> llenaListaQuimicos(List<QuimicoModel> quimicos) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (verificaQuimicos() == true) {
                for (QuimicoModel quimico : quimicos) {
                    em.persist(quimico);
                }

                transaction.commit();
            } else {
                return findQuimicoEntities();
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

        return quimicos;
    }

    /**
     * Metodo que busca todos los registros de quimicos en la base de datos
     *
     * @return lista de quimicos encontrados
     */
    @Override
    public List<QuimicoModel> findQuimicoEntities() {
        return findQuimicoEntities(true, -1, -1);
    }

    /**
     * Metodo que busca todos los registros de quimicos en la base de datos
     * @param maxResults
     * @param firstResult
     * @return lista de quimicos encontrados
     */
    @Override
    public List<QuimicoModel> findQuimicoEntities(int maxResults, int firstResult) {
        return findQuimicoEntities(false, maxResults, firstResult);
    }

    /**
     * Metodo que busca todos los registros de quimicos en la base de datos
     * @param all
     * @param maxResults
     * @param firstResult
     * @return lista de quimicos encontrados
     */
    @Override
    public List<QuimicoModel> findQuimicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(QuimicoModel.class));
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
     * Busca y devuelve un objeto QuimicoModel basado en su identificador único.
     *
     * @param id Identificador único del químico a buscar.
     * @return Objeto QuimicoModel encontrado o null si no se encuentra.
     */
    @Override
    public QuimicoModel findQuimico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(QuimicoModel.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que obtiene el numero de registros 
     * @return numero de registros
     */
    public int getQuimicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<QuimicoModel> rt = cq.from(QuimicoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Busca y devuelve un objeto QuimicoModel basado en su nombre.
     *
     * @return Objeto QuimicoModel encontrado o null si no se encuentra.
     */
    @Override
    public QuimicoModel findQuimicoNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<QuimicoModel> query = em.createQuery(
                    "SELECT q FROM QuimicoModel q WHERE q.nombre = :nombre", QuimicoModel.class);
            query.setParameter("nombre", nombre);
            List<QuimicoModel> resultados = query.getResultList();
            return resultados.get(0);
        } finally {
            em.close();
        }

    }

}
