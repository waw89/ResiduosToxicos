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
import com.daos.Solicitud_TransportistaDAOImp;
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
 * Clase que representa la capa de negocio en la solicitud del sistema
 *
 * @author xfs85
 */
public class SolicitudNegocio {

    IEspecificacionDAO especificacionDAO = new EspecificacionResiduosDAOImp();
    Util util = new Util();
    ISolicitudTrasladoDAO sdao = new SolicitudTrasladoDAOImp();
    Solicitud_TransportistaDAOImp soicitudTransportista_transportistaDAO = new Solicitud_TransportistaDAOImp();

    public SolicitudTrasladoModel guardar(DTOSolicitaTraslado dtoSolicitaTraslado) {
        SolicitudTrasladoModel st = util.convertirSolicitudTrasladoDTOaSolicitudTraslado(dtoSolicitaTraslado);
        sdao.create(st);
        return st;
    }

    /**
     * Método que actualiza la solicitud de traslado y las especificaciones de
     * residuos
     *
     * @param dtoSolicitaTraslado la solicitud de trasladoDTO a convertir en
     * solicitud de traslado model
     * @param especificacion la especificación de residuo a actualizar
     * @return
     */
    public SolicitudTrasladoModel actualizar(DTOSolicitaTraslado dtoSolicitaTraslado, Especificacion_Residuos especificacion) {
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
     *
     * @param listaTransportistas la lista de empresas transportistas
     * @param especificacion el residuo especificado del que se obtendrá la
     * cantidad del residuo
     */
    public void repartirCantidad(List<TransportistaModel> listaTransportistas, Especificacion_Residuos especificacion) {

        List<Solicitud_Transportista> registrosSolicituTransportista = this.soicitudTransportista_transportistaDAO.findSolicitud_TransportistaEntities();
        for (Solicitud_Transportista registro : registrosSolicituTransportista) {

            if (registro.getSolicitud().getId() == especificacion.getSolicitud().getId()) {
                List<ResiduoModel> residuos = registro.getSolicitud().getListaResiduos();

                for (ResiduoModel residuo : residuos) {
                    if (residuo.getId() == especificacion.getResiduo().getId()) {
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

    /**
     * Metodo que verifica que no existan 5 traslados en un mismo día
     *
     * @param fecha
     * @return true/flase dependiendo si existen o no
     */
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

    /**
     * Metodo que obtiene la lista de la tabla de especificación de residuos,
     * consultando la capa de persistencia
     *
     * @return lista de especificaciones de residuo
     */
    public List<Especificacion_Residuos> obtenerListaEspecificacionesResiduos() {
        List<Especificacion_Residuos> listaEspecificacionResiduos = new ArrayList<>();
        listaEspecificacionResiduos = especificacionDAO.findEspecificacion_ResiduosEntities();

        return listaEspecificacionResiduos;

    }

    /**
     * Metodo que se encarga de actualizar la cantidad del residuo
     * @param cantidadesResiduos 
     */
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

    /**
     * Metodo que valida si una solicitud es existente
     * @param dtoSolicitudARegistrar
     * @return 
     */
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
