/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.ISolicitudTrasladoDAO;
import com.daos.SolicitudTrasladoDAOImp;
import com.dto.DTOSolicitaTraslado;
import com.utilerias.Util;
import entitys.SolicitudTrasladoModel;

/**
 *
 * @author xfs85
 */
public class SolicitudNegocio {

    Util util = new Util();
    ISolicitudTrasladoDAO sdao = new SolicitudTrasladoDAOImp();
    
    public SolicitudTrasladoModel guardar(DTOSolicitaTraslado dtoSolicitaTraslado){
       SolicitudTrasladoModel st =  util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitaTraslado);
       sdao.create(st);
       return st;
    }

}
