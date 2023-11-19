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
 *
 * @author PRIDE ANACONDA
 */
public class UsuarioDAOImp implements IUsuarioDAO{

    public UsuarioDAOImp() {
        
    }
    private EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

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

    

    public List<UsuarioModel> findUsuarioModelEntities() {
        return findUsuarioModelEntities(true, -1, -1);
    }

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

    public UsuarioModel findUsuarioModel(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioModel.class, id);
        } finally {
            em.close();
        }
    }

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
    
    @Override
    public UsuarioModel consultaCredenciales(String nomUsuario, String contraseña) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<UsuarioModel> query = em.createQuery(
            "SELECT u FROM UsuarioModel u WHERE u.usuario = :nomUsuario AND u.password = :contraseña", UsuarioModel.class);
        query.setParameter("nomUsuario", nomUsuario);
        query.setParameter("contraseña", contraseña);
        
     
        
             UsuarioModel usuario = query.getSingleResult();
        
        return usuario;
        
    }catch(NoResultException e){
        return null;
    }finally {
        em.close();
    }
}
    

    
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
        
        public boolean verificaUsuarios() {
  
        if (findUsuarioModelEntities().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    
}
