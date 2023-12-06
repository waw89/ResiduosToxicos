/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.QuimicoModel;
import entitys.UsuarioModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 * Implementación de la interfaz IUsuarioDAO que define las operaciones de acceso a datos
 * para la entidad UsuarioModel.
 *
 * @author PRIDE ANACONDA
 */
public class UsuarioDAOImp implements IUsuarioDAO {

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
     * Crea y persiste un nuevo usuario en la base de datos.
     *
     * @param usuarioModel Objeto UsuarioModel a ser creado y persistido.
     * @return Objeto UsuarioModel creado y almacenado en la base de datos.
     */
    @Override
    public UsuarioModel create(UsuarioModel usuarioModel) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioModel);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuarioModel;
    }

    /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     *
     * @return Lista de objetos UsuarioModel.
     */
    @Override
    public List<UsuarioModel> findUsuarioModelEntities() {
        return findUsuarioModelEntities(true, -1, -1);
    }

    /**
     * Obtiene una lista paginada de usuarios almacenados en la base de datos.
     *
     * @param maxResults Número máximo de resultados por página.
     * @param firstResult Índice del primer resultado a recuperar.
     * @return Lista paginada de objetos UsuarioModel.
     */
    @Override
    public List<UsuarioModel> findUsuarioModelEntities(int maxResults, int firstResult) {
        return findUsuarioModelEntities(false, maxResults, firstResult);
    }

    private List<UsuarioModel> findUsuarioModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioModel.class));
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
     * Busca y devuelve un usuario basado en su identificador único.
     *
     * @param id Identificador único del usuario a buscar.
     * @return Objeto UsuarioModel encontrado o null si no se encuentra.
     */
    @Override
    public UsuarioModel findUsuarioModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioModel.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene la cantidad total de usuarios almacenados en la base de datos.
     *
     * @return Cantidad total de usuarios.
     */
    @Override
    public int getUsuarioModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioModel> rt = cq.from(UsuarioModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Consulta las credenciales de un usuario en la base de datos.
     *
     * @param nomUsuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     * @return Objeto UsuarioModel si las credenciales son válidas, o null si no se encuentra.
     */
    @Override
    public UsuarioModel consultaCredenciales(String nomUsuario, String contraseña) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<UsuarioModel> query = em.createQuery(
                    "SELECT u FROM UsuarioModel u WHERE u.usuario = :nomUsuario AND u.password = :contraseña",
                    UsuarioModel.class);
            query.setParameter("nomUsuario", nomUsuario);
            query.setParameter("contraseña", contraseña);

            try {
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            }
        } finally {
            em.close();
        }
    }

    /**
     * Llena la lista de usuarios en la base de datos.
     *
     * @param usuarios Lista de usuarios a ser almacenada en la base de datos.
     * @return Lista de usuarios almacenada en la base de datos.
     */
    @Override
    public List<UsuarioModel> llenaListaUsuarios(List<UsuarioModel> usuarios) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            if (verificaUsuarios() == true) {
                for (UsuarioModel usuario : usuarios) {
                    em.merge(usuario);
                }

                transaction.commit();
            } else {
                return findUsuarioModelEntities();
            }

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuarios;
    }

    /**
     * Verifica si existen usuarios en la base de datos.
     *
     * @return true si existen usuarios, false si no hay usuarios.
     */
    public boolean verificaUsuarios() {
        return findUsuarioModelEntities().isEmpty();
    }
}
