/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import com.daos.exceptions.NonexistentEntityException;
import entitys.Especificacion_Residuos;
import java.util.List;

/**
 * Interfaz que pertenece al DAO de la tabla "Solicitud_Residuo"
 *
 * @author xfs85
 */
public interface IEspecificacionDAO {

    /**
     * Metodo que edita la tabla de registros
     *
     * @param especificacion_Residuos
     * @throws NonexistentEntityException
     * @throws Exception
     */
    public void edit(Especificacion_Residuos especificacion_Residuos) throws NonexistentEntityException, Exception;

    /**
     * Metodo que elimina registro de la base de datos
     *
     * @param id
     * @throws NonexistentEntityException
     */
    public void destroy(Long id) throws NonexistentEntityException;

    /**
     * Metodo que obtiene los registros de la base de datos
     *
     * @return lista de especificaciones de residuo
     */
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities();

    /**
     * Metodo que busca los registros de la base de datos
     *
     * @param maxResults
     * @param firstResult
     * @return lista de especificaciones de residuos
     */
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(int maxResults, int firstResult);

    /**
     * Metodo que busca los registros de la base de datos
     *
     * @param all
     * @param maxResults
     * @param firstResult
     * @return lista de especificacion de residuos
     */
    public List<Especificacion_Residuos> findEspecificacion_ResiduosEntities(boolean all, int maxResults, int firstResult);

    /**
     * Metodo que busca los registros de la base de datos en base a su id
     *
     * @param id
     * @return especificacion de residuos
     */
    public Especificacion_Residuos findEspecificacion_Residuos(Long id);

    /**
     * Metodo que obtiene el numero de registros de la base de datos
     *
     * @return numero de registros
     */
    public int getEspecificacion_ResiduosCount();

}
