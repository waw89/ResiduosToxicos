/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilerias;

import com.dto.DTOIniciarSesion;
import com.dto.DTORegistraResiduo;
import com.dto.DTOSolicitaTraslado;
import entitys.AdministradorModel;
import entitys.ProductorModel;
import entitys.QuimicoModel;
import entitys.ResiduoModel;
import entitys.SolicitudTrasladoModel;
import entitys.TransportistaModel;
import entitys.UsuarioModel;
import entitys.VehiculoModel;
import java.util.ArrayList;
import java.util.List;

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
    public DTOIniciarSesion convertirUsuarioAUsuarioDTO(UsuarioModel usuario) {
        return new DTOIniciarSesion(usuario.getTipo(), usuario.getNombre(), usuario.getUsuario(), usuario.getPassword());

    }

//    public Usuario ConvertirDTOUsuarioAUsuario(DTOUsuario DTOusuario) {
//        if (DTOusuario != null) {
//            return new Usuario(DTOusuario.getTipo(), DTOusuario.getNombre(), DTOusuario.getUsuario(), DTOusuario.getPassword());
//        }
//        return null;
//    }
    public UsuarioModel ConvertirDTOUsuarioAUsuario(DTOIniciarSesion dtoIniciarSesion) {
        if (dtoIniciarSesion != null) {
            return new UsuarioModel(dtoIniciarSesion.getTipo(), dtoIniciarSesion.getNombre(), dtoIniciarSesion.getUsuario(), dtoIniciarSesion.getContraseña());
        }
        return null;
    }

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
        residuo.setProductor(residuoDTO.getId_productor());
        return residuo;
    }

    public SolicitudTrasladoModel convertirSolicitudTrasladoDTOaSolicitudTraslado(DTOSolicitaTraslado solicitudTrasladoDTO) {

        SolicitudTrasladoModel solicitudTraslado = new SolicitudTrasladoModel();

        solicitudTraslado.setAsignado(solicitudTrasladoDTO.isAsignado());
        solicitudTraslado.setFecha(solicitudTrasladoDTO.getFecha());
        solicitudTraslado.setCantidadRes(solicitudTrasladoDTO.getCantidadRes());
        solicitudTraslado.setListaResiduos(solicitudTrasladoDTO.getResiduos());
        solicitudTraslado.setProd(solicitudTrasladoDTO.getProductor());

        return solicitudTraslado;
    }

//    public ArrayList<DTOIniciarSesion> creaDTOUsuarios(){
//        
//        
//        DTOIniciarSesion usuario1 = new DTOIniciarSesion();
//        usuario1.setTipo("Productor");
//        usuario1.setNombre("Raúl");
//        usuario1.setContraseña("1234");
//        usuario1.setUsuario("rully");
//       
//        ConvertirDTOUsuarioAUsuario(usuario1);
//      
//        ArrayList nuevosUsuarios = new ArrayList();
//        
//        if(nuevosUsuarios.isEmpty()){
//        nuevosUsuarios.add(usuario1); 
//        }
//        return nuevosUsuarios;
//    }
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
    


       
    }

