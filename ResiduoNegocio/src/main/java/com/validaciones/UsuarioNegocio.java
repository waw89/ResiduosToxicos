/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import com.daos.UsuarioDAOImp;
import com.daos.IUsuarioDAO;
import com.utilerias.Util;
import entitys.UsuarioModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la capa de negocio del usuario
 *
 * @author PRIDE ANACONDA
 */
public class UsuarioNegocio {

    IUsuarioDAO udao = new UsuarioDAOImp();
    Util util = new Util();
    ArrayList<UsuarioModel> usuarios;

    /**
     * Metodo que confirma las credenciales ingresadas por el usuario,
     * consultando la capa de persistencia
     *
     * @param usuario
     * @param contraseña
     * @return las credenciales encontradas en la base de datos
     */
    public UsuarioModel confirmaCredenciales(String usuario, String contraseña) {

        if (udao.consultaCredenciales(usuario, contraseña) != null) {
            return udao.consultaCredenciales(usuario, contraseña);
//                return utilUsasrio.ConvertirDTOUsuarioAUsuario(interfaceUsuario.consultaCredenciales(usuario, password)); 
        } else {
            return null;
        }
//
//
//
    }

    /**
     * Metodo que llena la lista de usuarios, consultando la capa de
     * persistencia
     *
     * @return lista de usuarios
     */
    public List<UsuarioModel> llenaListaUsuarios() {

        this.usuarios = util.creaUsuarios();

        return udao.llenaListaUsuarios(usuarios);
    }

    /**
     * Metodo que obtiene la lista de usuariosModel
     *
     * @return lista de usuarios
     */
    public List<UsuarioModel> obtieneListaUsuarios() {

        return this.usuarios;
    }

}
