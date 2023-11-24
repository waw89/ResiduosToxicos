/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daos;

import entitys.ResiduoModel;
import java.util.List;

/**
 *
 * @author xfs85
 */
public interface IResiduoDAO {
    public ResiduoModel crear(ResiduoModel residuo);
    public List<ResiduoModel> cargaResiduos(List<ResiduoModel> residuos);
    public ResiduoModel findResiduoModel(long id);
    public ResiduoModel findResiduoNombre(String nombre);
    public List<ResiduoModel> findResiduoModelEntities();
    
}
