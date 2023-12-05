/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dto;

import entitys.SolicitudTrasladoModel;
import entitys.VehiculoModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PRIDE ANACONDA
 */
public class DTORegistraTraslado {
    String tratamiento;
    LocalDate fecha;
    List<Long> idsVehiculos;
    Float costo;
    Float kms;
    SolicitudTrasladoModel solicitud;
    String tipo;
    
    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Long> getidsVehiculos() {
        return idsVehiculos;
    }

    public void setidsVehiculos(List<Long> idsVehiculos) {
        this.idsVehiculos = idsVehiculos;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Float getKms() {
        return kms;
    }

    public void setKms(Float kms) {
        this.kms = kms;
    }

    public List<Long> getIdsVehiculos() {
        return idsVehiculos;
    }

    public void setIdsVehiculos(List<Long> idsVehiculos) {
        this.idsVehiculos = idsVehiculos;
    }

    public SolicitudTrasladoModel getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudTrasladoModel solicitud) {
        this.solicitud = solicitud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DTORegistraTraslado{" + "idsVehiculos=" + idsVehiculos + '}';
    }
    
    
    
    
    
    
    
}
