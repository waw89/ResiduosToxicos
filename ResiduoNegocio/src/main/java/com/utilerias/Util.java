/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilerias;

import com.dto.DTOIniciarSesion;
import com.dto.DTORegistraResiduo;
import com.dto.DTORegistraTraslado;
import com.dto.DTOSolicitaTraslado;
import com.validaciones.VehiculoNegocio;
import entitys.AdministradorModel;
import entitys.ProductorModel;
import entitys.QuimicoModel;
import entitys.ResiduoModel;
import entitys.SolicitudTrasladoModel;
import entitys.TransportistaModel;
import entitys.TrasladoModel;
import entitys.UsuarioModel;
import entitys.VehiculoModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilrerías
 *
 * @author PRIDE ANACONDA
 */
public class Util {

    /**
     *
     * @param usuario
     * @return DTOUsuario
     *
     * Convierte un objeto de tipo Usuario a un UsuarioDTO
     */
    public DTOIniciarSesion convertirUsuarioAUsuarioDTO(UsuarioModel usuario) {
        return new DTOIniciarSesion(usuario.getTipo(), usuario.getNombre(), usuario.getUsuario(), usuario.getPassword());

    }

    /**
     * Metodo que convierte un objeto de tipo UsuarioDTO a un UsuarioModel
     *
     * @param dtoIniciarSesion
     * @return
     */
    public UsuarioModel ConvertirDTOUsuarioAUsuario(DTOIniciarSesion dtoIniciarSesion) {
        if (dtoIniciarSesion != null) {
            return new UsuarioModel(dtoIniciarSesion.getTipo(), dtoIniciarSesion.getNombre(), dtoIniciarSesion.getUsuario(), dtoIniciarSesion.getContraseña());
        }
        return null;
    }

    /**
     * Metodo que crea los objetos de tipo quimico
     *
     * @return
     */
    public ArrayList<QuimicoModel> creaQuimicos() {
        QuimicoModel quim1 = new QuimicoModel("Plomo", null);
        QuimicoModel quim2 = new QuimicoModel("Cianuro", null);
        QuimicoModel quim3 = new QuimicoModel("Cobre", null);
        QuimicoModel quim4 = new QuimicoModel("Arsénico", null);

        ArrayList nuevosQuimicos = new ArrayList();

        nuevosQuimicos.add(quim1);
        nuevosQuimicos.add(quim2);
        nuevosQuimicos.add(quim3);
        nuevosQuimicos.add(quim4);

        return nuevosQuimicos;
    }

    /**
     * Metodo que convierte un objeto de tipo RegistraResiduoDTO a un Residuo
     *
     * @param residuoDTO
     * @return
     */
    public ResiduoModel convertirResiduoDTOAResiduo(DTORegistraResiduo residuoDTO) {

        ResiduoModel residuo = new ResiduoModel();

        residuo.setCodigo(residuoDTO.getCodigo_residuo());
        residuo.setNombre(residuoDTO.getNombre_residuo());
        residuo.setListaQuimicos(residuoDTO.getQuimicos());
        residuo.setListaSolTraslados(null);
        residuo.setProductor(residuoDTO.getId_productor());
        return residuo;
    }

    /**
     * Metodo que convierte un objeto tipo ResiduoModel a un DTORegistraResiduo
     *
     * @param residuo
     * @return
     */
    public DTORegistraResiduo convertirResiduoADTORegistraResiduo(ResiduoModel residuo) {
        DTORegistraResiduo DTORegistrarResiduo = new DTORegistraResiduo();
        DTORegistrarResiduo.setCodigo_residuo(residuo.getCodigo());
        DTORegistrarResiduo.setNombre_residuo(residuo.getNombre());
        DTORegistrarResiduo.setId_productor(residuo.getProductor());
        DTORegistrarResiduo.setQuimicos(residuo.getListaQuimicos());

        return DTORegistrarResiduo;
    }

    /**
     * Metodo que convierte un objeto tipo DTOSolicitaTraslado a un
     * SolicitudTrasladoModel
     *
     * @param solicitudTrasladoDTO
     * @return
     */
    public SolicitudTrasladoModel convertirSolicitudTrasladoDTOaSolicitudTraslado(DTOSolicitaTraslado solicitudTrasladoDTO) {

        SolicitudTrasladoModel solicitudTraslado = new SolicitudTrasladoModel();

        solicitudTraslado.setAsignado(solicitudTrasladoDTO.isAsignado());
        solicitudTraslado.setFecha(solicitudTrasladoDTO.getFecha());
        solicitudTraslado.setListaResiduos(solicitudTrasladoDTO.getResiduos());
        solicitudTraslado.setProd(solicitudTrasladoDTO.getProductor());
        solicitudTraslado.setTransportistas(solicitudTrasladoDTO.getTransportistas());
        //versión preeliminar 
        solicitudTraslado.setId(solicitudTrasladoDTO.getId());
        return solicitudTraslado;
    }

    /**
     * Metodo que convierte un objeto tipo SolicitudTrasladoModel a un
     * DTOSolicitaTraslado
     *
     * @param solicitud
     * @return
     */
    public DTOSolicitaTraslado convertirSolicitudTrasladoASolicitudTrasladoDTO(SolicitudTrasladoModel solicitud) {

        DTOSolicitaTraslado solicitudTrasladoDTO = new DTOSolicitaTraslado();

        solicitudTrasladoDTO.setAsignado(solicitud.esAsignado());
        solicitudTrasladoDTO.setFecha(solicitud.getFecha());
        solicitudTrasladoDTO.setResiduos(solicitud.getListaResiduos());
        solicitudTrasladoDTO.setProductor(solicitud.getProd());
        solicitudTrasladoDTO.setTransportistas(solicitud.getTransportistas());
        //Versión preeliminar
        solicitudTrasladoDTO.setId(solicitud.getId());
        return solicitudTrasladoDTO;
    }

    /**
     * Metodo que crea objetos tipo usuarioModel
     *
     * @return
     */
    public ArrayList<UsuarioModel> creaUsuarios() {

        // Los parametros son tipo,nombre, nombre de usuario y contraseña
        ProductorModel usuario1 = new ProductorModel("Productor", "Raúl", "rully", "1234");

        AdministradorModel usuario2 = new AdministradorModel("Administrador", "Luis", "waw", "1234");

        TransportistaModel usuario3 = new TransportistaModel("Transportista", "Softcode", "softcode", "1234");

        TransportistaModel usuario4 = new TransportistaModel("Transportista", "DHL", "dhl", "1234");

        ArrayList nuevosUsuarios = new ArrayList();

        if (nuevosUsuarios.isEmpty()) {
            nuevosUsuarios.add(usuario1);
            nuevosUsuarios.add(usuario2);
            nuevosUsuarios.add(usuario3);
            nuevosUsuarios.add(usuario4);
        }
        return nuevosUsuarios;
    }

    /**
     * Metodo que convierte un objeto de tipo DTORegistraTraslado a un
     * TrasladoModel
     *
     * @param dtoRegistraTraslado
     * @return
     */
    public TrasladoModel ConvertirDTOTrasladoATraslado(DTORegistraTraslado dtoRegistraTraslado) {
        VehiculoNegocio vn = new VehiculoNegocio();

        TrasladoModel traslado = new TrasladoModel();
        traslado.setCostoTotal(dtoRegistraTraslado.getCosto());
        traslado.setFechaLlegada(dtoRegistraTraslado.getFecha());
        traslado.setKmTotales(dtoRegistraTraslado.getKms());
        traslado.setVehiculos(vn.convertirVehiculos(dtoRegistraTraslado.getIdsVehiculos()));
        traslado.setSolicitudTraslado(dtoRegistraTraslado.getSolicitud());
        traslado.setTipoTraslado(dtoRegistraTraslado.getTipo());
        traslado.setTratamiento(dtoRegistraTraslado.getTratamiento());

        return traslado;

    }

}
