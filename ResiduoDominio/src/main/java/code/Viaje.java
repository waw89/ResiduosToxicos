/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "Id_Viaje")
    private Long id;

    @Basic
    @Column (name = "Km_Recorridos")
    private double km_Recorridos;
    
    @Basic
    @Column (name = "CostoViaje")
    private double costoViaje;
    
    @Basic
    @Column (name = "CantidadRes")
    private float cantidadRes;
    
    @Temporal (TemporalType.DATE)
    @Column (name = "FechaLlegada")
    private LocalDate fechaLlegada;
    
    @ManyToOne
    @JoinColumn (name = "IdVehiculo")
    private Vehiculo veh;
    
    @ManyToOne
    @JoinColumn (name = "IdTraslado")
    private Traslado tras;

    public Viaje() {
    
    }

    public Viaje(Long id, double km_Recorridos, double costoViaje, float cantidadRes, LocalDate fechaLlegada, Vehiculo veh, Traslado tras) {
        this.id = id;
        this.km_Recorridos = km_Recorridos;
        this.costoViaje = costoViaje;
        this.cantidadRes = cantidadRes;
        this.fechaLlegada = fechaLlegada;
        this.veh = veh;
        this.tras = tras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getKm_Recorridos() {
        return km_Recorridos;
    }

    public void setKm_Recorridos(double km_Recorridos) {
        this.km_Recorridos = km_Recorridos;
    }

    public double getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(double costoViaje) {
        this.costoViaje = costoViaje;
    }

    public float getCantidadRes() {
        return cantidadRes;
    }

    public void setCantidadRes(float cantidadRes) {
        this.cantidadRes = cantidadRes;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Vehiculo getVeh() {
        return veh;
    }

    public void setVeh(Vehiculo veh) {
        this.veh = veh;
    }

    public Traslado getTras() {
        return tras;
    }

    public void setTras(Traslado tras) {
        this.tras = tras;
    }

}
