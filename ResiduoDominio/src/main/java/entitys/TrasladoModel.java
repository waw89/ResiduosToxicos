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
 * Clase que representa la entidad traslado
 *
 * @author PRIDE ANACONDA
 */
@Entity
public class TrasladoModel implements Serializable {

    /**
     * id del traslado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_traslado")
    private Long id;

    /**
     * Metodo que obtiene el id del traslado
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que establece el id del traslado
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * kilometros del traslado
     */
    @Basic
    @Column(name = "km_totales")
    private double kmTotales;

    /**
     * Fecha de llegada del traslado
     */
    @Basic
    @Column(name = "fechaLlegada")
    private Date fechaLlegada;

    /**
     * Tratamiento del traslado
     */
    @Basic
    @Column(name = "tratamiento")
    private String tratamiento;

    /**
     * Costo del traslado
     */
    @Basic
    @Column(name = "costo_total")
    private double costoTotal;

    /**
     * Tipo de traslado
     */
    @Basic
    @Column(name = "tipoTraslado")
    private String tipoTraslado;

    /**
     * Solicitud a la que corresponde el traslado
     */
    @ManyToOne
    @JoinColumn(name = "IdSolicitud")
    private SolicitudTrasladoModel solicitudTraslado;

    /**
     * Vehiculo que corresponde al traslado Se crea la tabla asociación
     * "Traslado_Vehiculo"
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    /**
     * Metodo constructor con todos los atributos
     *
     * @param id
     * @param kmTotales
     * @param tratamiento
     * @param costoTotal
     * @param tipoTraslado
     * @param solicitudTraslado
     */
    public TrasladoModel(long id, double kmTotales, String tratamiento, double costoTotal, String tipoTraslado, SolicitudTrasladoModel solicitudTraslado) {
        this.id = id;
        this.kmTotales = kmTotales;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.tipoTraslado = tipoTraslado;
        this.solicitudTraslado = solicitudTraslado;

    }

    /**
     * Metodo constructor con todos los atributos, excepto solicitud
     *
     * @param kmTotales
     * @param tratamiento
     * @param costoTotal
     * @param fechaLlegada
     */
    public TrasladoModel(double kmTotales, String tratamiento, double costoTotal, LocalDate fechaLlegada) {
        this.kmTotales = kmTotales;
        this.tratamiento = tratamiento;
        this.costoTotal = costoTotal;
        this.fechaLlegada = Date.from(fechaLlegada.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Metodo que obtiene los kilometros
     *
     * @return
     */
    public double getKmTotales() {
        return kmTotales;
    }

    /**
     * Metodo que establece los kilometros
     *
     * @param kmTotales
     */
    public void setKmTotales(double kmTotales) {
        this.kmTotales = kmTotales;
    }

    /**
     * Metodo que obtiene el tratamiento
     *
     * @return tratamiento
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Metodo que establece el tratamiento
     *
     * @param tratamiento
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Metodo que obtiene el costo total
     *
     * @return costoTotal
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * Metodo que establece el costo total
     *
     * @param costoTotal
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * Metodo que obtiene el tipo de traslado
     *
     * @return
     */
    public String getTipoTraslado() {
        return tipoTraslado;
    }

    /**
     * Metodo que establece el tipo de traslado
     *
     * @param tipoTraslado
     */
    public void setTipoTraslado(String tipoTraslado) {
        this.tipoTraslado = tipoTraslado;
    }

    /**
     * Metodo que obtiene la solicitud
     *
     * @return solicitudTraslado
     */
    public SolicitudTrasladoModel getSolicitudTraslado() {
        return solicitudTraslado;
    }

    /**
     * Metodo que establece la solicitud de traslado
     *
     * @param solicitudTraslado
     */
    public void setSolicitudTraslado(SolicitudTrasladoModel solicitudTraslado) {
        this.solicitudTraslado = solicitudTraslado;
    }

    /**
     * Metodo que obtiene la fecha de llegada
     *
     * @return fechaLlegada
     */
    public LocalDate getFechaLlegada() {
        return fechaLlegada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Metodo que establece la fecha de llegada
     *
     * @param fechaLlegada
     */
    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = Date.from(fechaLlegada.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Metodo que obtiene la lista de vehiculos
     *
     * @return vehiculos
     */
    public List<VehiculoModel> getVehiculos() {
        return vehiculos;
    }

    /**
     * Metodo que establece la lista de vehiculos
     *
     * @param vehiculos
     */
    public void setVehiculos(List<VehiculoModel> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
