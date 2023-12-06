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
 * Clase que representa la capa de negocio del traslado
 *
 * @author xfs85
 */
public class TrasladoNegocio {

    Util util = new Util();
    ITrasladoDAO iTrasDAO = new TrasladoDAOImp();

    /**
     * Metodo que guarda un traslado, convirtiendo un DTO a TrasladoModel, tras
     * eso lo manda a persistencia
     *
     * @param dtoRegistraTraslado
     * @return
     */
    public TrasladoModel guardar(DTORegistraTraslado dtoRegistraTraslado) {
        TrasladoModel tras = util.ConvertirDTOTrasladoATraslado(dtoRegistraTraslado);
        iTrasDAO.create(tras);
        return tras;
    }

}
