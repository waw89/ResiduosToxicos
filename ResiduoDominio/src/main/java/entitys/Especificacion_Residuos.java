/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la tabla asociación entre las entidades
 * SolicitudTrasladoModel y ResiduoModel
 *
 * @author xfs85
 */
@Entity
@Table(name = "Solicitud_Residuos")
public class Especificacion_Residuos implements Serializable {

    /**
     * Id de la especificación
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Objeto de tipo SolicitudTrasladoModel
     */
    @ManyToOne
    @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud")
    private SolicitudTrasladoModel solicitud;

    /**
     * Objeto de tipo ResiduoModel
     */
    @ManyToOne
    @JoinColumn(name = "id_residuo", referencedColumnName = "id_residuo")
    private ResiduoModel residuo;

    /**
     * Cantidad de residuo en la solicitud
     */
    @Column(name = "cantidad")
    private float cantidad;

    /**
     * Este atributo representa si un residuo está asignado a una empresa
     * transportista
     */
    @Column(name = "asignado")
    private boolean asignado;

    /**
     * Metodo para obtener el id de la especificación del residuo
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo para establecer el id de la especificación del residuo
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo para obtener la solicitud de traslado
     *
     * @return solicitud
     */
    public SolicitudTrasladoModel getSolicitud() {
        return solicitud;
    }

    /**
     * Metodo para establecer la solicitud de traslado
     *
     * @param solicitud
     */
    public void setSolicitud(SolicitudTrasladoModel solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * Metodo para obtener el residuo que está en una solicitud de traslado
     *
     * @return residuo
     */
    public ResiduoModel getResiduo() {
        return residuo;
    }

    /**
     * Metodo para establecer el residuo que está en una solicitud de traslado
     *
     * @param residuo
     */
    public void setResiduo(ResiduoModel residuo) {
        this.residuo = residuo;
    }

    /**
     * Metodo para obtener la cantidad de un residuo
     *
     * @return cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Metodo para establecer la cantidad de un residuo
     *
     * @param cantidad
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Metodo para obtener si un residuo está asignado ono
     *
     * @return asignado
     */
    public boolean isAsignado() {
        return asignado;
    }

    /**
     * Metodo que establece si un residuo está asignado
     *
     * @param asignado
     */
    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    /**
     * Metodo toString de la entidad
     *
     * @return
     */
    @Override
    public String toString() {
        return "residuo=" + residuo.getNombre() + ", cantidad=" + cantidad;
    }

}
