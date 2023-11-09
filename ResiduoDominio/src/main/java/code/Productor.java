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
public class Productor {

    /**
     * Default constructor
     */
    public Productor() {
    }

    /**
     * 
     */
    private long id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private List<SolicitudTraslado> solicitudes = new ArrayList<>();

    public Productor(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregaSolicitud(SolicitudTraslado solicitud){
        solicitudes.add(solicitud); 
    }

    @Override
    public String toString() {
        return "Productor{" + "id=" + id + ", nombre=" + nombre + ", solicitudes=" + solicitudes + '}';
    }
    
}