/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */
@Entity
@Table (name = "SolicitudTraslado")
public class SolicitudTraslado implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "idSolicitud")
    private long id;

    /**
     *
     */
    @Temporal (TemporalType.DATE)
    @Column (name = "FechaTraslado")
    private Date fecha;

    /**
     *
     */
    @Basic
    @Column (name = "CantidadRes")
    private float cantidadRes;

    /**
     *
     */
    @Basic
    @Column (name = "Asignado")
    private boolean asignado;

    /**
     *
     */
    private Residuo residuo;

    /**
     *
     */
    @ManyToOne
    @JoinColumn (name = "IdTransportistas")
    private List<Transportista> trans;

    /**
     *
     */
    @ManyToMany
    @JoinColumn (name = "IdProductor")
    private Productor prod;

    /**
     * Default constructor
     */
    public SolicitudTraslado() {
    }

    public SolicitudTraslado(long id, Date fecha, float cantidadRes, boolean asignado, Residuo residuo, Productor productor) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRes = cantidadRes;
        this.asignado = asignado;
        this.residuo = residuo;
        this.prod = productor;
    }

    public SolicitudTraslado(long id, Date fecha, float cantidadRes, boolean asignado, Residuo residuo, List<Transportista> trans, Productor prod) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRes = cantidadRes;
        this.asignado = asignado;
        this.residuo = residuo;
        this.trans = trans;
        this.prod = prod;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidadRes() {
        return cantidadRes;
    }

    public void setCantidadRes(float cantidadRes) {
        this.cantidadRes = cantidadRes;
    }

    public boolean esAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }

    public List<Transportista> getTrans() {
        return trans;
    }

    public void setTrans(List<Transportista> trans) {
        this.trans = trans;
    }

    public Productor getProd() {
        return prod;
    }

    public void setProd(Productor prod) {
        this.prod = prod;
    }
    
    public void agregaTransportista(Transportista transportista){
        trans.add(transportista); 
    }
    
}
