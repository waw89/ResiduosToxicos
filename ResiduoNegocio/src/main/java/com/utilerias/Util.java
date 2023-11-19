/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilerias;

import com.dto.DTORegistraResiduo;
import com.dto.DTOSolicitaTraslado;
import entitys.QuimicoModel;
import entitys.ResiduoModel;
import entitys.SolicitudTrasladoModel;
import java.util.ArrayList;

/**
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
//    public DTOUsuario convertirUsuarioAUsuarioDTO(Usuario usuario) {
//        return new DTOUsuario(usuario.getId(), usuario.getTipo(), usuario.getNombre(), usuario.getUsuario(), usuario.getPassword());
//
//    }
//
//    public Usuario ConvertirDTOUsuarioAUsuario(DTOUsuario DTOusuario) {
//        if (DTOusuario != null) {
//            return new Usuario(DTOusuario.getTipo(), DTOusuario.getNombre(), DTOusuario.getUsuario(), DTOusuario.getPassword());
//        }
//        return null;
//    }
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

    public ResiduoModel convertirResiduoDTOAResiduo(DTORegistraResiduo residuoDTO) {

        ResiduoModel residuo = new ResiduoModel();

        residuo.setCodigo(residuoDTO.getCodigo_residuo());
        residuo.setNombre(residuoDTO.getNombre_residuo());
        residuo.setListaQuimicos(residuoDTO.getQuimicos());
        residuo.setListaSolTraslados(null);
        residuo.setProductor(null);
        return residuo;
    }

    public SolicitudTrasladoModel convertirSolicitudTrasladoDTOaSolicitudTraslado(DTOSolicitaTraslado solicitudTrasladoDTO) {

        SolicitudTrasladoModel solicitudTraslado = new SolicitudTrasladoModel();

        solicitudTraslado.setAsignado(solicitudTrasladoDTO.isAsignado());
        solicitudTraslado.setFecha(solicitudTrasladoDTO.getFecha());
        solicitudTraslado.setCantidadRes(solicitudTrasladoDTO.getCantidadRes());
        solicitudTraslado.setListaResiduos(solicitudTrasladoDTO.getResiduos());
        solicitudTraslado.setProd(null);

        return solicitudTraslado;
    }
}
