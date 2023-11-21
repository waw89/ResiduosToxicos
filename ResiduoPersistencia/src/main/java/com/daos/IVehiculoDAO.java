/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.VehiculoModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface IVehiculoDAO {
    public VehiculoModel create(VehiculoModel vehiculoModel);
    public List<VehiculoModel> findVehiculoModelEntities();
    public List<VehiculoModel> findVehiculoModelEntities(int maxResults, int firstResult);
    public VehiculoModel findVehiculoModel(Long id);
    public int getVehiculoModelCount();
    public List<VehiculoModel> obtenerVehiculosPorTransportista(Long idTransportista);
    
}
