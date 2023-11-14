/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 */
@Entity
@Table(name= "Traslado")
public class Traslado implements Serializable {

    /**
     * Default constructor
     */
    public Traslado() {
    }

    /**
     * 
     */
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    @Column (name = "Id_Traslado")
    private long id;

    /**
     * 
     */
    @Basic
    @Column (name= "km_totales")
    private double kmTotales;

    /**
     * 
     */
    @Basic
    @Column (name= "destino")
    private String destino;

    /**
     * 
     */
    @Basic
    @Column (name= "tratamiento")
    private String tratamiento;

    /**
     * 
     */
    @Basic
    @Column(name= "costo_total")
    private double costoTotal;

    /**
     * 
     */
    @OneToOne
    private TipoTraslado tipoTraslado;

    /**
     * 
     */
   

    /**
     * 
     */
    @OneToOne
    private SolicitudTraslado solicitudTraslado;

    /**
     * 
     */
    @OneToMany (mappedBy = "veh", cascade = CascadeType.ALL)
    private List<Vehiculo> listaVehiculos;
    
    
    /**
     * 
     */
    @Temporal (TemporalType.DATE)
    @Column (name = "FechaLlegada")
    private LocalDate fechaLlegada;

    
    
    public Traslado(long id, double kmTotales, String destino, String tratamiento, double costoTotal, TipoTraslado tipoTraslado, SolicitudTraslado solicitudTraslado, List<Vehiculo> listaVehiculos, LocalDate fechaLlegada) {
        this.id = id;
        this.kmTotales = kmTotales;
        this.destino = destino;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.tipoTraslado = tipoTraslado;
        this.solicitudTraslado = solicitudTraslado;
        this.listaVehiculos = listaVehiculos;
        this.fechaLlegada = fechaLlegada;
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
        listaVehiculos.add(vehiculo);
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

  
}