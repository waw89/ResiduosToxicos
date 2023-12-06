package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entitys.SolicitudTrasladoModel;
import entitys.TransportistaModel;
import java.util.ArrayList;
import java.util.List;
import entitys.VehiculoModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Implementación de la interfaz ITransportistaDAO que define las operaciones de
 * acceso a datos para la entidad TransportistaModel.
 *
 * @author PRIDE ANACONDA
 */
public class TransportistaDAOImp implements ITransportistaDAO {

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
     * Crea y persiste una nueva entidad de empresa transportista en la base de
     * datos.
     *
     * @param transportistaModel Objeto TransportistaModel a ser creado y
     * persistido.
     * @return Objeto TransportistaModel creado y almacenado en la base de
     * datos.
     */
    @Override
    public TransportistaModel create(TransportistaModel transportistaModel) {
        // En este método se debería realizar la lógica para crear y persistir la entidad.
        // Actualmente, el método simplemente devuelve el objeto transportistaModel sin realizar ninguna acción.
        return transportistaModel;
    }

    /**
     * Obtiene una lista de todas las empresas transportistas almacenadas en la
     * base de datos.
     *
     * @return Lista de objetos TransportistaModel.
     */
    @Override
    public List<TransportistaModel> findTransportistaModelEntities() {
        return findTransportistaModelEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista paginada de empresas transportistas almacenadas en la
     * base de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos TransportistaModel.
     */
    public List<TransportistaModel> findTransportistaModelEntities(int maxResults, int firstResult) {
        return findTransportistaModelEntities(false, maxResults, firstResult);
    }

    private List<TransportistaModel> findTransportistaModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TransportistaModel.class));
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
     * Busca y devuelve una empresa transportista basada en su identificador
     * único.
     *
     * @param id Identificador único de la empresa transportista a buscar.
     * @return Objeto TransportistaModel encontrado o null si no se encuentra.
     */
    @Override
    public TransportistaModel findTransportistaModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TransportistaModel.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene la cantidad total de empresas transportistas almacenadas en la
     * base de datos.
     *
     * @return Cantidad total de empresas transportistas.
     */
    @Override
    public int getTransportistaModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TransportistaModel> rt = cq.from(TransportistaModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Método cargaTransportistas que regresa la lista de empresas
     * transportistas desde la base de datos.
     *
     * @param transportistas Lista de empresas transportistas que se regresará.
     * @return Lista de empresas transportistas.
     */
    @Override
    public List<TransportistaModel> cargaTransportistas(List<TransportistaModel> transportistas) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (verificaTransportistas()) {
                for (TransportistaModel transportista : transportistas) {
                    em.persist(transportista);
                }
                transaction.commit();
            } else {
                return findTransportistaModelEntities();
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
        return transportistas;
    }

    /**
     * Método verificaTransportistas que regresa true en caso de encontrar
     * empresas transportistas en la base de datos, false caso contrario.
     *
     * @return true en caso de encontrar empresas transportistas, false caso
     * contrario.
     */
    public boolean verificaTransportistas() {
        return findTransportistaModelEntities().isEmpty();
    }
}
