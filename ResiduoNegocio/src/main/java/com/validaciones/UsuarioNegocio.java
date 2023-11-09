/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validaciones;

import code.Productor;
import code.Usuario;
import com.dao.IUsuarioDAO;
import com.dao.UsuarioDAOImp;
import com.utilerias.Util;

/**
 *
 * @author PRIDE ANACONDA
 */
public class UsuarioNegocio {
    IUsuarioDAO interfaceUsuario = new UsuarioDAOImp(); 
    Util utilUsario = new Util();

    public void cargaUsuariosProductores(){
        Usuario user = new Productor(1, "Productor", "luis", "6442327211", "Kikirimiau7**"); 
        Productor productor = (Productor) user;
        productor.setId(1);
       
    }
    public Usuario confirmaCredenciales(String usuario, String password){
        
            
            if (interfaceUsuario.consultaCredenciales(usuario, password)!=null){
                 return utilUsario.ConvertirDTOUsuarioAUsuario(interfaceUsuario.consultaCredenciales(usuario, password)); 
            }else{
                return null;
            }
        
           
       
    }
}
