/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

import entitys.ProductorModel;
import entitys.QuimicoModel;
import java.util.List;

/**
 *
 * @author PRIDE ANACONDA
 */
public class DTORegistraResiduo {
   
    private String nombre_residuo; 
    private Long codigo_residuo;
    private List<QuimicoModel> quimicos;
    private ProductorModel id_productor;
    
    public DTORegistraResiduo() {
    }

    public String getNombre_residuo() {
        return nombre_residuo;
    }

    public Long getCodigo_residuo() {
        return codigo_residuo;
    }

    public List<QuimicoModel> getQuimicos() {
        return quimicos;
    }

    public ProductorModel getId_productor() {
        return id_productor;
    }

    public void setNombre_residuo(String nombre_residuo) {
        this.nombre_residuo = nombre_residuo;
    }

    public void setCodigo_residuo(Long codigo_residuo) {
        this.codigo_residuo = codigo_residuo;
    }

    public void setQuimicos(List<QuimicoModel> quimicos) {
        this.quimicos = quimicos;
    }

    public void setId_productor(ProductorModel id_productor) {
        this.id_productor = id_productor;
    }
    
    
    
}
