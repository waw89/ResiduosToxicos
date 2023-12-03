/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Especificacion_Residuos;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface IEspecificacionDAO {
    
    public void edit(Especificacion_Residuos especificacion_Residuos) throws NonexistentEntityException, Exception;
    public void destroy(Long id) throws NonexistentEntityException;
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities();
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(int maxResults, int firstResult);
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(boolean all, int maxResults, int firstResult);
    public Especificacion_Residuos findEspecificacion_Residuos(Long id);
    public int getEspecificacion_ResiduosCount();
    
}
