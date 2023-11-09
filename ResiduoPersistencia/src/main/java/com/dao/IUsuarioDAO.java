/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import com.dto.DTOUsuario;
/**
 *
 * @author PRIDE ANACONDA
 */
public interface IUsuarioDAO {
    
    //List<DTOProductor> getAll();
    //void insert(PersonaDTO usuario);
    public DTOUsuario consultaCredenciales(String usuario, String password); 
}
