/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

import entitys.ProductorModel;
import entitys.ResiduoModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author xfs85
 */
public class DTOSolicitaTraslado {
    private LocalDate fecha;
    private float cantidadRes;
    private List<ResiduoModel> residuos;
    private ProductorModel productor;
    private boolean asignado;

    public DTOSolicitaTraslado() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getCantidadRes() {
        return cantidadRes;
    }

    public void setCantidadRes(float cantidadRes) {
        this.cantidadRes = cantidadRes;
    }

    public List<ResiduoModel> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<ResiduoModel> residuos) {
        this.residuos = residuos;
    }

    public ProductorModel getProductor() {
        return productor;
    }

    public void setProductor(ProductorModel productor) {
        this.productor = productor;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    
    
    
    
    
}
