/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.ITrasladoDAO;
import com.daos.TrasladoDAOImp;
import com.dto.DTORegistraTraslado;
import com.utilerias.Util;
import entitys.TrasladoModel;

/**
 *
 * @author xfs85
 */
public class TrasladoNegocio {
    Util util = new Util();
    ITrasladoDAO iTrasDAO = new TrasladoDAOImp();
    
    public TrasladoModel guardar(DTORegistraTraslado dtoRegistraTraslado){
        TrasladoModel tras = util.ConvertirDTOTrasladoATraslado(dtoRegistraTraslado);
        iTrasDAO.create(tras);
        return tras;
    }
    
    
    
    
}
