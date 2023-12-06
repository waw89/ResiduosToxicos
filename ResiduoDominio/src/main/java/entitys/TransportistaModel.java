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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Clase que representa la entidad Transportista, Hereda de Usuario
 *
 * @author PRIDE ANACONDA
 */
@Entity
@PrimaryKeyJoinColumn(name = "IdTransportista")
@DiscriminatorValue("Transportista")
@Table(name = "Transportista")
public class TransportistaModel extends UsuarioModel implements Serializable {

//    /**
//     * Lista de solicitudes
//     */
    @ManyToMany(mappedBy = "transportistas")
    private List<SolicitudTrasladoModel> listaSolicitudes;

    /**
     * Lista de vehiculos que posee
     */
    @OneToMany(mappedBy = "trans", cascade = CascadeType.ALL)
    private List<VehiculoModel> listaVehiculos;

    /**
     * Default constructor
     */
    public TransportistaModel() {
    }

    /**
     * Metodo constructor con los atributos de la clase padre
     *
     */
    public TransportistaModel(String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
    }

    /**
     * Metodo constructor con todos los atributos
     *
     * @param listaSolicitudes
     * @param listaVehiculos
     * @param tipo
     * @param nombre
     * @param usuario
     * @param password
     */
    public TransportistaModel(List<SolicitudTrasladoModel> listaSolicitudes, List<VehiculoModel> listaVehiculos, String tipo, String nombre, String usuario, String password) {
        super(tipo, nombre, usuario, password);
//        this.listaSolicitudes = listaSolicitudes;
        this.listaVehiculos = listaVehiculos;
    }

    /**
     * Metodo que obtiene la lista de solicitudes
     *
     * @return listaSolicitudes
     */
    public List<SolicitudTrasladoModel> getListaSolicitudes() {
        return listaSolicitudes;
    }

    /**
     * Metodo que establece la lista de solicitudes
     *
     * @param listaSolicitudes
     */
    public void setListaSolicitudes(List<SolicitudTrasladoModel> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    /**
     * Metodo que obtiene la lista de vehiculos
     *
     * @return listaVehiculos
     */
    public List<VehiculoModel> getListaVehiculos() {
        return listaVehiculos;
    }

    /**
     * Metodo que establece la lista de vehiculos
     *
     * @param listaVehiculos
     */
    public void setListaVehiculos(List<VehiculoModel> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    /**
     * Metodo que agrega vehiculos al transportista
     *
     * @param vehiculo
     */
    public void agregaVehiculo(VehiculoModel vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    /**
     * Método toString que regresa el nombre de la empresa
     *
     * @return el nombre de la empresa transportista
     */
    @Override
    public String toString() {
        return "---" + this.getNombre();
    }

}
