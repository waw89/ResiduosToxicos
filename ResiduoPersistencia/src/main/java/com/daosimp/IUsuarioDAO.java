/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daosimp;

import code.Usuario;

/**
 *
 * @author PRIDE ANACONDA
 */
public interface IUsuarioDAO {
    
    //List<DTOProductor> getAll();
    //void insert(PersonaDTO usuario);
    public Usuario consultaCredenciales(String usuario, String password); 
}
