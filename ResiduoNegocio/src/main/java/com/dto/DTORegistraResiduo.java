/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

import entitys.ProductorModel;
import entitys.QuimicoModel;
import java.util.List;

/**
 * Clase que representa el DTO del caso de uso Registrar Residuo
 *
 * @author PRIDE ANACONDA
 */
public class DTORegistraResiduo {

    /**
     * Todos los atributos
     */
    private String nombre_residuo;
    private Long codigo_residuo;
    private List<QuimicoModel> quimicos;
    private ProductorModel id_productor;

    /**
     * Metodo constructor por omisión
     */
    public DTORegistraResiduo() {
    }

    /**
     * Metodo que obtiene el nombre del residuo DTO
     *
     * @return
     */
    public String getNombre_residuo() {
        return nombre_residuo;
    }

    /**
     * Metodo que obtiene el codigo del residuoDTO
     *
     * @return
     */
    public Long getCodigo_residuo() {
        return codigo_residuo;
    }

    /**
     * Metodo que obtiene la lista de quimicos que conforman el residuoDTO
     *
     * @return
     */
    public List<QuimicoModel> getQuimicos() {
        return quimicos;
    }

    /**
     * Metodo que obtiene el id del productor
     *
     * @return
     */
    public ProductorModel getId_productor() {
        return id_productor;
    }

    /**
     * Metodo que establece el nombre del residuoDTO
     *
     * @param nombre_residuo
     */
    public void setNombre_residuo(String nombre_residuo) {
        this.nombre_residuo = nombre_residuo;
    }

    /**
     * Metodo que establece el codigo del residuoDTO
     *
     * @param codigo_residuo
     */
    public void setCodigo_residuo(Long codigo_residuo) {
        this.codigo_residuo = codigo_residuo;
    }

    /**
     * Metodo que establece la lista de quimicos
     *
     * @param quimicos
     */
    public void setQuimicos(List<QuimicoModel> quimicos) {
        this.quimicos = quimicos;
    }

    /**
     * Metodo que establece el id del productor
     *
     * @param id_productor
     */
    public void setId_productor(ProductorModel id_productor) {
        this.id_productor = id_productor;
    }

}
