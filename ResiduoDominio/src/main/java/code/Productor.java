/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@PrimaryKeyJoinColumn (name = "IdProductor")
@DiscriminatorValue (value = "Productor")
@Table (name = "Productor")
public class Productor extends Usuario implements Serializable{
    /**
     * 
     */
    @OneToMany (mappedBy = "prod", cascade = CascadeType.ALL)
    private List<SolicitudTraslado> listaSolicitudes;
    
    @OneToMany (mappedBy = "prod", cascade = CascadeType.ALL)
    private List<Residuo> listaResiduos;
    /**
     * Default constructor
     */
    public Productor() {
    
    }

    public Productor(String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
       
    }

    public Productor(List<SolicitudTraslado> solicitudes, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = solicitudes;
    }

    public Productor(List<SolicitudTraslado> listaSolicitudes, List<Residuo> listaResiduos,String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = listaSolicitudes;
        this.listaResiduos = listaResiduos;
    }
   
    public void agregaSolicitud(SolicitudTraslado solicitud){
        listaSolicitudes.add(solicitud); 
    }

    public List<SolicitudTraslado> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudTraslado> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<Residuo> getListaResiduos() {
        return listaResiduos;
    }

    public void setListaResiduos(List<Residuo> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }
    
    

}