/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Traslado {

    /**
     * Default constructor
     */
    public Traslado() {
    }

    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private double kmTotales;

    /**
     * 
     */
    private String destino;

    /**
     * 
     */
    private String tratamiento;

    /**
     * 
     */
    private double costoTotal;

    /**
     * 
     */
    private TipoTraslado tipoTraslado;

    /**
     * 
     */
   

    /**
     * 
     */
    private SolicitudTraslado solicitudTraslado;

    /**
     * 
     */
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
    private LocalDate fechaLlegada;

    public Traslado(long id, double kmTotales, String destino, String tratamiento, double costoTotal, TipoTraslado tipoTraslado, SolicitudTraslado solicitudTraslado, LocalDate fechaLlegada) {
        this.id = id;
        this.kmTotales = kmTotales;
        this.destino = destino;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.tipoTraslado = tipoTraslado;
        this.solicitudTraslado = solicitudTraslado;
        this.fechaLlegada =fechaLlegada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getKmTotales() {
        return kmTotales;
    }

    public void setKmTotales(double kmTotales) {
        this.kmTotales = kmTotales;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public TipoTraslado getTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(TipoTraslado tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public SolicitudTraslado getSolicitudTraslado() {
        return solicitudTraslado;
    }

    public void setSolicitudTraslado(SolicitudTraslado solicitudTraslado) {
        this.solicitudTraslado = solicitudTraslado;
    }
    
    public void agregaVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setViajes(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    

    @Override
    public String toString() {
        return "Traslado{" + "id=" + id + ", kmTotales=" + kmTotales + ", destino=" + destino + ", tratamiento=" + tratamiento + ", costoTotal=" + costoTotal + ", tipoTraslado=" + tipoTraslado +    ", solicitudTraslado=" + solicitudTraslado + ", vehiculos=" + vehiculos + '}';
    }
    
}