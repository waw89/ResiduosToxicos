/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Transportista extends Usuario {

    /**
     * Default constructor
     */
    public Transportista() {
    }

    /**
     *
     */
    private long id;



    /**
     *
     */
    private SolicitudTraslado solicitud;

    /**
     *
     */
    private List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     *
     */
    
    private List<Viaje> viajes = new ArrayList<>();

    public Transportista(long id, String nombre) {
        super("Trasnsportista", nombre); 
        this.id = id;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public SolicitudTraslado getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudTraslado solicitud) {
        this.solicitud = solicitud;
    }


    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setTraslados(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public void agregaTraslado(Viaje viaje) {
        viajes.add(viaje);
    }

    public void agregaVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Transportista{" + "id=" + id +  ", solicitud=" + solicitud + ", vehiculos=" + vehiculos + ", viajes=" + viajes.toString() + '}';
    }
    
    
}
