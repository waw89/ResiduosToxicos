/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 */
@Entity
@PrimaryKeyJoinColumn (name = "IdTransportista")
@DiscriminatorValue (value = "Transportista")
@Table(name = "Transportista")
public class Transportista extends Usuario implements Serializable{

    /**
     *
     */
    @OneToMany (mappedBy = "trans", cascade = CascadeType.ALL)
    private List<SolicitudTraslado> listaSolicitudes;

    /**
     *
     */
    
    @OneToMany (mappedBy = "trans", cascade = CascadeType.ALL)
    private List<Vehiculo> listaVehiculos;

    /**
     * Default constructor
     */
    public Transportista() {
    }
    
    /**
     *
     * 
     */
    public Transportista(List<SolicitudTraslado> listaSolicitudes, List<Vehiculo> listaVehiculos,String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
        this.listaSolicitudes = listaSolicitudes;
        this.listaVehiculos = listaVehiculos;
    }

    public List<SolicitudTraslado> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudTraslado> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void agregaVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

}
