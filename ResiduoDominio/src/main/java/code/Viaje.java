/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

/**
 * 
 */
public class Viaje {

    /**
     * Default constructor
     */
    public Viaje() {
    }

    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private double km_recorridos;

    /**
     * 
     */
    private double costoViaje;

    /**
     * 
     */
    private Vehiculo vehiculo;

    /**
     * 
     */
    private Traslado traslado;
    
    private float cantidadRes;
    
    private Transportista transportista;

    public Viaje(long id, double km_recorridos, double costoViaje, Vehiculo vehiculo, Traslado traslado, Transportista transportista, float cantidadRes) {
        this.id = id;
        this.km_recorridos = km_recorridos;
        this.costoViaje = costoViaje;
        this.vehiculo = vehiculo;
        this.traslado = traslado;
        this.transportista = transportista;
        this.cantidadRes = cantidadRes;

    }  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getKm_recorridos() {
        return km_recorridos;
    }

    public void setKm_recorridos(double km_recorridos) {
        this.km_recorridos = km_recorridos;
    }

    public double getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(double costoViaje) {
        this.costoViaje = costoViaje;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    @Override
    public String toString() {
        return "Viaje{" + "id=" + id + ", km_recorridos=" + km_recorridos + ", costoViaje=" + costoViaje + ", vehiculo=" + vehiculo + ", traslado=" + traslado + '}';
    }
    
    
}