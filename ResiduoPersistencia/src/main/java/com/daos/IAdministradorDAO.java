/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.AdministradorModel;
import java.util.List;

/**
 * Interfaz para la clase AdministradorDAOImp
 * @author xfs85
 */
public interface IAdministradorDAO {
    /**
     * Crea un registro en la base de datos
     * @param administradorModel
     * @return administradorModel
     */
     public AdministradorModel create(AdministradorModel administradorModel);
     
     /**
      * Metodo que busca registros en la base de datos
      * @return lista de administradores
      */
     public List<AdministradorModel> findAdministradorModelEntities();
     /**
      * Metodo que busca los registros en la base de datos
      * @param maxResults
      * @param firstResult
      * @return lista de administradores
      */
     public List<AdministradorModel> findAdministradorModelEntities(int maxResults, int firstResult);
     
     /**
      * Metodo que busca los registros en la base de datos
      * @param id
      * @return administradorModel
      */
     public AdministradorModel findAdministradorModel(Long id);
     
     /**
      * Metodo que obtiene el numero de registros por el id
      * @return numero de registros
      */
     public int getAdministradorModelCount();
     
}
