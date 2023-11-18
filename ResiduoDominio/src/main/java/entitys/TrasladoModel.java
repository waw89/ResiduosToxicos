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
import javax.persistence.OneToOne;

/**
 *
 * @author PRIDE ANACONDA
 */
@Entity
public class TrasladoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   /**
     * 
     */
    @Basic
    @Column (name= "km_totales")
    private double kmTotales;

    /**
     * 
     */
    @Basic
    @Column (name= "destino")
    private String destino;

    /**
     * 
     */
    @Basic
    @Column (name= "tratamiento")
    private String tratamiento;

    /**
     * 
     */
    @Basic
    @Column(name= "costo_total")
    private double costoTotal;
    
    /**
     * 
     */
    @Basic
    @Column(name="tipoTraslado")
    private String tipoTraslado;

    /**
     * 
     */
    @OneToOne
    private SolicitudTrasladoModel solicitudTraslado;



    /**
     * Default constructor
     */
    public TrasladoModel() {
    }
    
    public TrasladoModel(long id, double kmTotales, String destino, String tratamiento, double costoTotal, String tipoTraslado, SolicitudTrasladoModel solicitudTraslado) {
        this.id = id;
        this.kmTotales = kmTotales;
        this.destino = destino;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.tipoTraslado = tipoTraslado;
        this.solicitudTraslado = solicitudTraslado;

    }

 

    public double getKmTotales() {
        return kmTotales;
    }

    public void setKmTotales(double kmTotales) {
        this.kmTotales = kmTotales;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTipoTraslado() {
        return tipoTraslado;
    }

    public void setTipoTraslado(String tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    public SolicitudTrasladoModel getSolicitudTraslado() {
        return solicitudTraslado;
    }

    public void setSolicitudTraslado(SolicitudTrasladoModel solicitudTraslado) {
        this.solicitudTraslado = solicitudTraslado;
    }
}
