/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.SolicitudTrasladoModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface ISolicitudTrasladoDAO {
    public SolicitudTrasladoModel create(SolicitudTrasladoModel solicitudTrasladoModel);
    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities();
    public List<SolicitudTrasladoModel> findSolicitudTrasladoModelEntities(int maxResults, int firstResult);
    public SolicitudTrasladoModel findSolicitudTrasladoModel(Long id);
    public int getSolicitudTrasladoModelCount();
    
}
