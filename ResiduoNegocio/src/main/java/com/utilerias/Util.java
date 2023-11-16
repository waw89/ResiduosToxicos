/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilerias;

import code.Quimico;
import code.Usuario;
import com.dto.DTOUsuario;
import java.util.ArrayList;
import java.util.List;

;

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
    public DTOUsuario convertirUsuarioAUsuarioDTO(Usuario usuario) {
        return new DTOUsuario(usuario.getId(), usuario.getTipo(), usuario.getNombre(), usuario.getUsuario(), usuario.getPassword());

    }

    public Usuario ConvertirDTOUsuarioAUsuario(DTOUsuario DTOusuario) {
        if (DTOusuario != null) {
            return new Usuario(DTOusuario.getTipo(), DTOusuario.getNombre(), DTOusuario.getUsuario(), DTOusuario.getPassword());
        }
        return null;
    }

    public List<Quimico> creaQuimicos() {
        Quimico quim1 = new Quimico("Plomo");
        Quimico quim2 = new Quimico("Cianuro");
        Quimico quim3 = new Quimico("Cobre");
        Quimico quim4 = new Quimico("Arsénico");

        List nuevosQuimicos = new ArrayList();

        nuevosQuimicos.add(quim1);
        nuevosQuimicos.add(quim2);
        nuevosQuimicos.add(quim3);
        nuevosQuimicos.add(quim4);

        return nuevosQuimicos;
    }
}
