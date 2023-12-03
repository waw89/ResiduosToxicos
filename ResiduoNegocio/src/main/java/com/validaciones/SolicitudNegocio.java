/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.EspecificacionResiduosDAOImp;
import com.daos.IEspecificacionDAO;
import com.daos.ISolicitudTrasladoDAO;
import com.daos.SolicitudTrasladoDAOImp;
import com.dto.DTOSolicitaTraslado;
import com.daos.Solicitud_TransportistaJpaController;
import com.utilerias.Util;
import entitys.Especificacion_Residuos;
import entitys.ResiduoModel;
import entitys.SolicitudTrasladoModel;
import entitys.Solicitud_Transportista;
import entitys.TransportistaModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class SolicitudNegocio {

    IEspecificacionDAO especificacionDAO = new EspecificacionResiduosDAOImp();
    Util util = new Util();
    ISolicitudTrasladoDAO sdao = new SolicitudTrasladoDAOImp();
    Solicitud_TransportistaJpaController soicitudTransportista_transportistaDAO = new Solicitud_TransportistaJpaController();

    public SolicitudTrasladoModel guardar(DTOSolicitaTraslado dtoSolicitaTraslado) {
        SolicitudTrasladoModel st = util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitaTraslado);
        sdao.create(st);
        return st;
    }

    /**
     * Método que actualiza la solicitud de traslado y las especificaciones de residuos
     * @param dtoSolicitaTraslado la solicitud de trasladoDTO a convertir en solicitud de traslado model
     * @param especificacion la especificación de residuo a actualizar
     * @return 
     */
    public SolicitudTrasladoModel actualizar(DTOSolicitaTraslado dtoSolicitaTraslado, Especificacion_Residuos especificacion){
        SolicitudTrasladoModel solicitudTraslado = util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitaTraslado);
        try {
            especificacionDAO.edit(especificacion);
        } catch (Exception e) {
            
        }
        
        return sdao.update(solicitudTraslado);
    }

    /**
     * Método repartirCantidad que reparte la cantidad del residuo entre las
     * empresas transportistas
     * @param listaTransportistas la lista de empresas transportistas
     * @param especificacion el residuo especificado del que se obtendrá la cantidad del residuo
     */
    public void repartirCantidad(List<TransportistaModel> listaTransportistas, Especificacion_Residuos especificacion) {
       
        List<Solicitud_Transportista> registrosSolicituTransportista = this.soicitudTransportista_transportistaDAO.findSolicitud_TransportistaEntities();
        for (Solicitud_Transportista registro : registrosSolicituTransportista) {
            
            if(registro.getSolicitud().getId() == especificacion.getSolicitud().getId()){
                List<ResiduoModel> residuos = registro.getSolicitud().getListaResiduos();
                
                for(ResiduoModel residuo: residuos){
                    if(residuo.getId() == especificacion.getResiduo().getId()){
                        especificacion.getResiduo().getId();
                        registro.setCantidad(especificacion.getCantidad() / listaTransportistas.size());
                        
                        try {
                            this.soicitudTransportista_transportistaDAO.edit(registro);
                        } catch (Exception e) {
                        }
                    }
                }
     
            }
            
        }

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

    public List<Especificacion_Residuos> obtenerListaEspecificacionesResiduos() {
        List<Especificacion_Residuos> listaEspecificacionResiduos = new ArrayList<>();
//        if(especificacionDAO.getEspecificacion_ResiduosCount() == 0){
////        int i = especificacionDAO.getEspecificacion_ResiduosCount();
////
////        for (int n = 0; n <= i; n++) {
////            if (especificacionDAO.findEspecificacion_Residuos((long) n) != null) {
////                Especificacion_Residuos especificacionResiduo = especificacionDAO.findEspecificacion_Residuos((long) n);
////                listaEspecificacionResiduos.add(especificacionResiduo);
////            }
////
////        }

        listaEspecificacionResiduos = especificacionDAO.findEspecificacion_ResiduosEntities();
//        }else{
//            int i = especificacionDAO.getEspecificacion_ResiduosCount()-1;
//            
//            for (int n = 0; n <= i; n++) {
//                if (especificacionDAO.findEspecificacion_Residuos((long) n) != null) {
//                    Especificacion_Residuos especificacionResiduo = especificacionDAO.findEspecificacion_Residuos((long) n);
//                    listaEspecificacionResiduos.add(especificacionResiduo);
//                }
//
//            }
//        }

        return listaEspecificacionResiduos;

    }

    public void actualizaCantidadDelResiduo(List<Float> cantidadesResiduos) {
        if (especificacionDAO.getEspecificacion_ResiduosCount() == 0) {
            int i = especificacionDAO.getEspecificacion_ResiduosCount();

            Especificacion_Residuos registroEspecificacion;
            for (Float cantidad : cantidadesResiduos) {

                registroEspecificacion = especificacionDAO.findEspecificacion_Residuos((long) i);

                registroEspecificacion.setCantidad(cantidad);

                try {
                    especificacionDAO.edit(registroEspecificacion);
                } catch (Exception e) {

                }
                i++;
            }
        } else {
            int i = especificacionDAO.getEspecificacion_ResiduosCount() - 1;
            Especificacion_Residuos registroEspecificacion;
            for (Float cantidad : cantidadesResiduos) {

                registroEspecificacion = especificacionDAO.findEspecificacion_Residuos((long) i);

                registroEspecificacion.setCantidad(cantidad);

                try {
                    especificacionDAO.edit(registroEspecificacion);
                } catch (Exception e) {

                }
                i++;
            }
        }

    }

    public boolean validaSolicitudNoExistente(DTOSolicitaTraslado dtoSolicitudARegistrar) {
        SolicitudTrasladoModel solicitudARegistrar = util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitudARegistrar);
        List<SolicitudTrasladoModel> solicitudes = sdao.findSolicitudTrasladoModelEntities();

        boolean solicitudNoExistente = true;

        for (SolicitudTrasladoModel solicitudActual : solicitudes) {
            if (solicitudActual == null || solicitudARegistrar == null) {
                return false; // Manejo de error o lanzar una excepción según tu lógica de negocio
            }

            LocalDate fechaSolicitudRegistrada = solicitudActual.getFecha();

            if (fechaSolicitudRegistrada.equals(solicitudARegistrar.getFecha())) {
                JOptionPane.showMessageDialog(null, "Ya tienes una solicitud para esta fecha, selecciona otra");
                return false;
            }

            List<ResiduoModel> listaResiduoRegistrado = solicitudActual.getListaResiduos();
            List<ResiduoModel> listaResiduoARegistrar = solicitudARegistrar.getListaResiduos();

            if (listaResiduoRegistrado.size() == listaResiduoARegistrar.size()) {
                // Solo verifica si las listas tienen la misma longitud
                boolean mismaCombinacion = true;

                for (ResiduoModel residuoActualSolicitudARegistrar : listaResiduoARegistrar) {
                    boolean residuoEncontrado = false;

                    for (ResiduoModel residuoActualSolicitudRegistrado : listaResiduoRegistrado) {
                        // Ajusta la comparación según tu lógica específica para los residuos
                        if (residuoActualSolicitudARegistrar.getNombre().equalsIgnoreCase(residuoActualSolicitudRegistrado.getNombre())) {
                            residuoEncontrado = true;
                            break; // Si se encuentra un residuo, no es necesario seguir buscando
                        }
                    }

                    if (residuoEncontrado) {
                        mismaCombinacion = false;
                        JOptionPane.showMessageDialog(null, "Ya tienes una solicitud con estos residuos, selecciona otros");
                        return false; // Si un residuo se encuentra, la combinación no es la misma
                    }
                }

                if (mismaCombinacion) {
                    return false; // La combinación de residuos ya existe en otra solicitud, retorna false
                }
            }

            if (!solicitudNoExistente) {
                return false; // Si se encontró una coincidencia, termina la verificación y retorna false
            }
        }

        return solicitudNoExistente; // Retorna el resultado final
    }

}
