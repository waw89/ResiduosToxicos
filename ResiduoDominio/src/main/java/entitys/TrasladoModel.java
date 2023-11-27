/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author PRIDE ANACONDA
 */
@Entity
public class TrasladoModel implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_traslado")
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

   @Basic
   @Column (name= "fechaLlegada")
   private Date fechaLlegada;

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
    @ManyToOne
    @JoinColumn(name = "IdSolicitud")
    private SolicitudTrasladoModel solicitudTraslado;
    
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Traslado_Vehiculo",
            joinColumns = @JoinColumn(name = "id_traslado"),
            inverseJoinColumns = @JoinColumn(name = "id_vehiculo")
    )
    private List<VehiculoModel> vehiculos;


    /**
     * Default constructor
     */
    public TrasladoModel() {
    }
    
    public TrasladoModel(long id, double kmTotales, String tratamiento, double costoTotal, String tipoTraslado, SolicitudTrasladoModel solicitudTraslado) {
        this.id = id;
        this.kmTotales = kmTotales;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.tipoTraslado = tipoTraslado;
        this.solicitudTraslado = solicitudTraslado;

    }

    public TrasladoModel(double kmTotales, String tratamiento, double costoTotal, LocalDate fechaLlegada) {
        this.kmTotales = kmTotales;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.fechaLlegada = Date.from(fechaLlegada.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    
 

    public double getKmTotales() {
        return kmTotales;
    }

    public void setKmTotales(double kmTotales) {
        this.kmTotales = kmTotales;
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

    public LocalDate getFechaLlegada() {
        return fechaLlegada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = Date.from(fechaLlegada.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public List<VehiculoModel> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoModel> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    
    
    
}
