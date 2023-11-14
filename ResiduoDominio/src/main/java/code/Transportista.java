/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "Transportista")
public class Transportista extends Usuario {

    /**
     * Default constructor
     */
    public Transportista() {
    }

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    public Transportista(long id, String nombre, String usuario_correo, String passowrd_usuario) {
        super("Trasnsportista", nombre, usuario_correo, passowrd_usuario);
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

    public void agregaVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Transportista{" + "id=" + id + ", solicitud=" + solicitud + ", vehiculos=" + vehiculos + '}';
    }

}
