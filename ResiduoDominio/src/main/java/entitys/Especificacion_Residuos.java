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
 *
 * @author xfs85
 */


@Entity
@Table(name = "Solicitud_Residuos")
public class Especificacion_Residuos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud")
    private SolicitudTrasladoModel solicitud;

    @ManyToOne
    @JoinColumn(name = "id_residuo", referencedColumnName = "id_residuo")
    private ResiduoModel residuo;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "asignado")
    private boolean asignado;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SolicitudTrasladoModel getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudTrasladoModel solicitud) {
        this.solicitud = solicitud;
    }

    public ResiduoModel getResiduo() {
        return residuo;
    }

    public void setResiduo(ResiduoModel residuo) {
        this.residuo = residuo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    
}


