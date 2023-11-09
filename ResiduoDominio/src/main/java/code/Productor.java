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
     * 
     */
    private long idProductor;

    /**
     * 
     */
  

    /**
     * 
     */
    private List<SolicitudTraslado> solicitudes = new ArrayList<>();
    
    /**
     * Default constructor
     */
    public Productor() {
    }

    public Productor(long idProductor, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.idProductor = idProductor;
       
    }

    public long getIdProductor() {
        return idProductor;
    }

    public void setId(long id) {
        this.idProductor = id;
    }

   
    public void agregaSolicitud(SolicitudTraslado solicitud){
        solicitudes.add(solicitud); 
    }

    @Override
    public String toString() {
        return "Productor{" + "id=" + idProductor +", solicitudes=" + solicitudes + '}';
    }
    
}