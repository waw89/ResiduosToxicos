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
import entitys.QuimicoModel;
import entitys.ResiduoModel;
import java.util.ArrayList;
import java.util.List;
import entitys.SolicitudTrasladoModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author xfs85
 */
public class ResiduoDAOImp implements IResiduoDAO {

    public ResiduoDAOImp() {
      
    }
    EntityManagerFactory emf = SingletonEntityManager.getEntityManagerFactory();

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ResiduoModel crear(ResiduoModel residuoModel) {
        if (residuoModel.getListaQuimicos() == null) {
            residuoModel.setListaQuimicos(new ArrayList<QuimicoModel>());
        }
        if (residuoModel.getListaSolTraslados() == null) {
            residuoModel.setListaSolTraslados(new ArrayList<SolicitudTrasladoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<QuimicoModel> attachedListaQuimicos = new ArrayList<QuimicoModel>();
            for (QuimicoModel listaQuimicosQuimicoModelToAttach : residuoModel.getListaQuimicos()) {
                listaQuimicosQuimicoModelToAttach = em.getReference(listaQuimicosQuimicoModelToAttach.getClass(), listaQuimicosQuimicoModelToAttach.getId());
                attachedListaQuimicos.add(listaQuimicosQuimicoModelToAttach);
            }
            residuoModel.setListaQuimicos(attachedListaQuimicos);
            List<SolicitudTrasladoModel> attachedListaSolTraslados = new ArrayList<SolicitudTrasladoModel>();
            for (SolicitudTrasladoModel listaSolTrasladosSolicitudTrasladoModelToAttach : residuoModel.getListaSolTraslados()) {
                listaSolTrasladosSolicitudTrasladoModelToAttach = em.getReference(listaSolTrasladosSolicitudTrasladoModelToAttach.getClass(), listaSolTrasladosSolicitudTrasladoModelToAttach.getId());
                attachedListaSolTraslados.add(listaSolTrasladosSolicitudTrasladoModelToAttach);
            }
            residuoModel.setListaSolTraslados(attachedListaSolTraslados);
            em.persist(residuoModel);
            for (QuimicoModel listaQuimicosQuimicoModel : residuoModel.getListaQuimicos()) {
                listaQuimicosQuimicoModel.getListaResiduos().add(residuoModel);
                listaQuimicosQuimicoModel = em.merge(listaQuimicosQuimicoModel);
            }
            for (SolicitudTrasladoModel listaSolTrasladosSolicitudTrasladoModel : residuoModel.getListaSolTraslados()) {
                listaSolTrasladosSolicitudTrasladoModel.getListaResiduos().add(residuoModel);
                listaSolTrasladosSolicitudTrasladoModel = em.merge(listaSolTrasladosSolicitudTrasladoModel);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return residuoModel;
    }

 

    public List<ResiduoModel> findResiduoModelEntities() {
        return findResiduoModelEntities(true, -1, -1);
    }

    public List<ResiduoModel> findResiduoModelEntities(int maxResults, int firstResult) {
        return findResiduoModelEntities(false, maxResults, firstResult);
    }

    private List<ResiduoModel> findResiduoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResiduoModel.class));
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

    public ResiduoModel findResiduoModel(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResiduoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getResiduoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResiduoModel> rt = cq.from(ResiduoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

   

    @Override
    public List<ResiduoModel> cargaResiduos(List<ResiduoModel> residuos) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            if (verificaResiduos()== true) {
                for (ResiduoModel residuo : residuos) {
                    em.persist(residuo);
                }

                transaction.commit();
            } else {
                return findResiduoModelEntities();
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

        return residuos;
        
        
    }


    @Override
    public ResiduoModel findResiduoNombre(String nombre) {
          EntityManager em = getEntityManager();
    try {
        TypedQuery<ResiduoModel> query = em.createQuery(
                "SELECT q FROM ResiduoModel q WHERE q.nombre = :nombre", ResiduoModel.class);
        query.setParameter("nombre", nombre);
        List<ResiduoModel> resultados = query.getResultList();
        return resultados.get(0);
    } finally {
        em.close();
    }
    }
    
    public boolean verificaResiduos() {
  
        if (findResiduoModelEntities().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
}
