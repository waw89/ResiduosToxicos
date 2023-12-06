/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la tabla asociación entre solicitud y transportista
 *
 * @author xfs85
 */
@Entity
@Table(name = "Solicitud_Transportista")
public class Solicitud_Transportista implements Serializable {

    /**
     * Id del registro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * id de la solicitud
     */
    @ManyToOne
    @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud")
    private SolicitudTrasladoModel solicitud;

    /**
     * id del transportista
     */
    @ManyToOne
    @JoinColumn(name = "id_transportista", referencedColumnName = "idTransportista")
    private TransportistaModel transportista;

    /**
     * Atributo que representa la cantidad de residuo que transporta cada
     * empresa
     */
    @Column(name = "cantidad")
    private float cantidad;

    /**
     * Metodo que obtiene el id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene la solicitud
     *
     * @return solicitud
     */
    public SolicitudTrasladoModel getSolicitud() {
        return solicitud;
    }

    /**
     * Metodo que establece la solicitud
     *
     * @param solicitud
     */
    public void setSolicitud(SolicitudTrasladoModel solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * Metodo que obtiene el transportista
     *
     * @return transportista
     */
    public TransportistaModel getTransportista() {
        return transportista;
    }

    /**
     * Metodo que establece el transportista
     *
     * @param transportista
     */
    public void setTransportista(TransportistaModel transportista) {
        this.transportista = transportista;
    }

    /**
     * Metodo que obtiene la cantidad asignada
     *
     * @return cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Metodo que establece la cantidad asignada
     *
     * @param cantidad
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

}
