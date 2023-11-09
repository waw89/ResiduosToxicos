/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilerias;

import code.Usuario;
import com.dto.DTOUsuario;
;

/**
 *
 * @author PRIDE ANACONDA
 */
public class Util {

    public DTOUsuario convertirUsuarioAUsuarioDTO(Usuario usuario) {
        return new DTOUsuario(usuario.getId(), usuario.getTipo(), usuario.getNombre(), usuario.getUsuario(), usuario.getPassword());

    }

    public Usuario ConvertirDTOUsuarioAUsuario(DTOUsuario DTOusuario) {
        if (DTOusuario != null){
        return new Usuario(DTOusuario.getTipo(), DTOusuario.getNombre(), DTOusuario.getUsuario(), DTOusuario.getPassword());
        }
        return null;
    }

}
