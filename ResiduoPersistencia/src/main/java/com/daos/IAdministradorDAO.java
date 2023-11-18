/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.AdministradorModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface IAdministradorDAO {
     public AdministradorModel create(AdministradorModel administradorModel);
     public List<AdministradorModel> findAdministradorModelEntities();
     public List<AdministradorModel> findAdministradorModelEntities(int maxResults, int firstResult);
     public AdministradorModel findAdministradorModel(Long id);
     public int getAdministradorModelCount();
     
}
