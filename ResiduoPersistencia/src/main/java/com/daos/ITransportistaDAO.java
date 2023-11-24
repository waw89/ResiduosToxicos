/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.TransportistaModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface ITransportistaDAO {
    public TransportistaModel create(TransportistaModel transportistaModel);
    public List<TransportistaModel> findTransportistaModelEntities();
    public TransportistaModel findTransportistaModel(Long id);
    public int getTransportistaModelCount();
    public List<TransportistaModel> cargaTransportistas(List<TransportistaModel> transportistaList);
    
}
