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
 *
 * @author PRIDE ANACONDA
 */
public class UsuarioNegocio {
    
    IUsuarioDAO udao = new UsuarioDAOImp(); 
    Util util = new Util();
//
//    public void cargaUsuariosProductores(){
//        Usuario user = new Productor("Productor", "luis", "6442327211", "Kikirimiau7**"); 
//        Productor productor = (Productor) user;
//        productor.setId(1);
//       
//    }
    
    public UsuarioModel confirmaCredenciales(String usuario, String contraseña){


            if (udao.consultaCredenciales(usuario, contraseña) != null){
                 return udao.consultaCredenciales(usuario, contraseña);
//                return utilUsasrio.ConvertirDTOUsuarioAUsuario(interfaceUsuario.consultaCredenciales(usuario, password)); 
            }else{
                return null;
            }
//
//
//
    }
    
    
    public List<UsuarioModel> llenaListaUsuarios(){
        ArrayList<UsuarioModel> usuarios = util.creaUsuarios();
        
        return udao.llenaListaUsuarios(usuarios);
    }

}
    