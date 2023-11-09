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
public class Productor extends Usuario {

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
  

    /**
     * 
     */
    private List<SolicitudTraslado> solicitudes = new ArrayList<>();

    public Productor(long id, String nombre) {
        super("Productor", nombre);
        this.id = id;
       
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    public void agregaSolicitud(SolicitudTraslado solicitud){
        solicitudes.add(solicitud); 
    }

    @Override
    public String toString() {
        return "Productor{" + "id=" + id +", solicitudes=" + solicitudes + '}';
    }
    
}