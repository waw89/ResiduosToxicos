/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.Especificacion_ResiduosJpaController;
import com.daos.ISolicitudTrasladoDAO;
import com.daos.SolicitudTrasladoDAOImp;
import com.dto.DTOSolicitaTraslado;
import com.utilerias.Util;
import entitys.Especificacion_Residuos;
import entitys.SolicitudTrasladoModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xfs85
 */
public class SolicitudNegocio {

    Especificacion_ResiduosJpaController especificacionDAO = new Especificacion_ResiduosJpaController();
    Util util = new Util();
    ISolicitudTrasladoDAO sdao = new SolicitudTrasladoDAOImp();

    public SolicitudTrasladoModel guardar(DTOSolicitaTraslado dtoSolicitaTraslado) {
        SolicitudTrasladoModel st = util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitaTraslado);
        sdao.create(st);
        return st;
    }

    public SolicitudTrasladoModel actualizar(DTOSolicitaTraslado dtoSolicitaTraslado) {
        SolicitudTrasladoModel st = util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitaTraslado);
        sdao.update(st);
        return st;
    }

    /**
     * Método obtenerSolicitudes que invoca al método de cargaSolicitudes de la
     * capa de persistencia para regresar la lista de solicitudes de traslado
     *
     * @return la lista de solicitudes de traslado
     */
    public List<SolicitudTrasladoModel> obtenerSolicitudes() {

        ArrayList<SolicitudTrasladoModel> solicitudesList = new ArrayList<>();
        List<SolicitudTrasladoModel> solicitudes = sdao.cargaSolicitudes(solicitudesList);

        return solicitudes;
    }

    public boolean verificarMaximoTrasladosPorDia(LocalDate fecha) {
        int contador = 0;

        List<SolicitudTrasladoModel> solicitudes = obtenerSolicitudes();

        for (SolicitudTrasladoModel solicitud : solicitudes) {
            if (solicitud.getFecha().equals(fecha)) {
                contador++;

                if (contador >= 5) {
                    return false;
                }
            }
        }
        return true;
    }

 

    public void actualizaCantidadDelResiduo(List<Float> cantidadesResiduos) {
        int i = especificacionDAO.getEspecificacion_ResiduosCount()-1;
        Especificacion_Residuos registroEspecificacion ; 
        for (Float cantidad : cantidadesResiduos) {
            
            registroEspecificacion = especificacionDAO.findEspecificacion_Residuos((long) i);
            
            registroEspecificacion.setCantidad(cantidad);
            registroEspecificacion.setAsignado(true);
            try {
                especificacionDAO.edit(registroEspecificacion);
            } catch (Exception e) {

            }
            i++;
        }

    }
    

}
