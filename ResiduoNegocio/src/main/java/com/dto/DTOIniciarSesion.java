/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

/**
 * Clase que representa el DTO para la función Iniciar Sesión
 * @author xfs85
 */
public class DTOIniciarSesion {
    
    /**
     * Atributos del DTO
     */
    private String tipo;
    private String nombre;
    private String nomUsuario;
    private String contraseña;

    /**
     * Metodo constructor por omisión
     */
    public DTOIniciarSesion() {
    }

    /**
     * Metodo constructor con todos los atributos
     * @param tipo
     * @param nombre
     * @param nomUsuario
     * @param contraseña 
     */
    public DTOIniciarSesion(String tipo, String nombre, String nomUsuario, String contraseña) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
    }
    
    

    /**
     * Metodo que obtiene el tipo de usuarioDTO
     * @return 
     */
    
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que establece el tipo de usuarioDTO
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que obtiene el nombre del usuarioDTO
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del usuarioDTO
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el username del usuarioDTO
     * @return 
     */
    public String getUsuario() {
        return nomUsuario;
    }

    /**
     * Metodo que establece el username del usuarioDTO
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.nomUsuario = nomUsuario;
    }

    /**
     * Metodo que obtiene contraseña del usuarioDTO
     * @return 
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Metodo que establece la contraseña del usuarioDTO
     * @param contraseña 
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    
    
    
}
