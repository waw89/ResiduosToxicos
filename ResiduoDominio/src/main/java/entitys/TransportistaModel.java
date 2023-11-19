/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

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
 * @author PRIDE ANACONDA
 */
@Entity
@PrimaryKeyJoinColumn (name = "IdTransportista")
@DiscriminatorValue ("Transportista")
@Table(name = "Transportista")
public class TransportistaModel extends UsuarioModel implements Serializable  {

 
//    /**
//     *
//     */
//    @OneToMany (mappedBy = "trans", cascade = CascadeType.ALL)
//    private List<SolicitudTrasladoModel> listaSolicitudes;

    /**
     *
     */
    
    @OneToMany (mappedBy = "trans", cascade = CascadeType.ALL)
    private List<VehiculoModel> listaVehiculos;

    /**
     * Default constructor
     */
    public TransportistaModel() {
    }
    
    /**
     *  
     * 
     */
    
    
    public TransportistaModel(String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
    }

    public TransportistaModel(List<SolicitudTrasladoModel> listaSolicitudes, List<VehiculoModel> listaVehiculos, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
//        this.listaSolicitudes = listaSolicitudes;
this.listaVehiculos = listaVehiculos;
    }

//    public List<SolicitudTrasladoModel> getListaSolicitudes() {
//        return listaSolicitudes;
//    }

//    public void setListaSolicitudes(List<SolicitudTrasladoModel> listaSolicitudes) {
//        this.listaSolicitudes = listaSolicitudes;
//    }

    public List<VehiculoModel> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<VehiculoModel> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void agregaVehiculo(VehiculoModel vehiculo) {
        listaVehiculos.add(vehiculo);
    }
}
