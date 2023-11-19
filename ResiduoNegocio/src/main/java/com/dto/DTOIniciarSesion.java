/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

/**
 *
 * @author xfs85
 */
public class DTOIniciarSesion {
    
    private String tipo;
    private String nombre;
    private String nomUsuario;
    private String contraseña;

    
    public DTOIniciarSesion() {
    }

    public DTOIniciarSesion(String tipo, String nombre, String nomUsuario, String contraseña) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
    }
    
    

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return nomUsuario;
    }

    public void setUsuario(String usuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
    
    
}
