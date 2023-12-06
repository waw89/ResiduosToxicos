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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la entidad SolicitudTraslado
 *
 * @author PRIDE ANACONDA
 */
@Entity
@Table(name = "SolicitudTraslado")
public class SolicitudTrasladoModel implements Serializable {

    /**
     * Id de la solicitud
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSolicitud")

    private Long id;

    /**
     * Metodo que obtiene el id
     *
     * @return
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
     * Fecha de la solicitud
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaTraslado")
    private Date fecha;

    /**
     * Estado de la solicitud
     */
    @Basic
    @Column(name = "Asignado")
    private boolean asignado;

    /**
     * Lista de residuos que contiene la solicitud Se crea la tabla asociación
     * "Solicitud_Residuos"
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Solicitud_Residuos",
            joinColumns = @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud"),
            inverseJoinColumns = @JoinColumn(name = "id_residuo", referencedColumnName = "id_residuo")
    )
    private List<ResiduoModel> listaResiduos;

    /**
     * Lista de traslados
     */
    @OneToMany(mappedBy = "solicitudTraslado", cascade = CascadeType.ALL)
    private List<TrasladoModel> listaTraslado;

//    /**
//     *
//     */
//    @ManyToOne
//    @JoinColumn(name = "IdTransportistas")
//    private List<TransportistaModel> trans;
    /**
     * Productor que realiza la solicitud
     */
    @ManyToOne
    @JoinColumn(name = "IdProductor")
    private ProductorModel prod;

    /**
     * Lista de transportistas Se crea la tabla asociación
     * "Solicitud_Transportista"
     */
    //Versión preeliminar
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Solicitud_Transportista",
            joinColumns = @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud"),
            inverseJoinColumns = @JoinColumn(name = "id_transportista", referencedColumnName = "idTransportista")
    )
    private List<TransportistaModel> transportistas;
    /////////

    /**
     * Default constructor
     */
    public SolicitudTrasladoModel() {
    }

    /**
     * Metodo constructor con todos los atributos
     *
     * @param id
     * @param fecha
     * @param asignado
     * @param listaResiduos
     * @param transportistas
     * @param prod
     */
    public SolicitudTrasladoModel(long id, LocalDate fecha, boolean asignado, List<ResiduoModel> listaResiduos, List<TransportistaModel> transportistas, ProductorModel prod) {
        this.id = id;
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());;
        this.asignado = asignado;
        this.listaResiduos = listaResiduos;
        this.transportistas = transportistas;
        this.prod = prod;
    }

    /**
     * Metodo que obtiene la fecha de la solicitud
     *
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Metodo que establece la fecha de la solicitud
     *
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Metodo que obtiene si una solicitud está asignada o no
     *
     * @return asignado
     */
    public boolean esAsignado() {
        return asignado;
    }

    /**
     * Metodo que establece si una solicitud está asignada o no
     *
     * @param asignado
     */
    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    /**
     * Metodo que obtiene la lista de residuos
     *
     * @return listaResiduos
     */
    public List<ResiduoModel> getListaResiduos() {
        return listaResiduos;
    }

    /**
     * Metodo que establece la lista de residuos
     *
     * @param listaResiduos
     */
    public void setListaResiduos(List<ResiduoModel> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }

    /**
     * Metodo que obtiene la lista de transportistas
     *
     * @return
     */
    //versión preeliminar
    public List<TransportistaModel> getTransportistas() {
        return this.transportistas;
    }

    /**
     * Metodo que establece la lista de transportistas
     *
     * @param transportistas
     */
    public void setTransportistas(List<TransportistaModel> transportistas) {
        this.transportistas = transportistas;
    }
    //////

    /**
     * Metodo que obtiene el productor
     *
     * @return prod
     */
    public ProductorModel getProd() {
        return prod;
    }

    /**
     * Metodo que establece el productor
     *
     * @param prod
     */
    public void setProd(ProductorModel prod) {
        this.prod = prod;
    }

    /**
     * Método toString que muestra la fecha de la solicitud, la lista de los
     * residuos en la solicitud y el productor que solicitó el traslado
     *
     * @return la fecha de la solicitud del traslado, los residuos de la
     * solicitud de traslado y el productor que solicitó el traslado
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de Solicitud: ").append(getFecha()).append("\n");

        if (getListaResiduos() != null && !getListaResiduos().isEmpty()) {
            sb.append("\nResiduos:\n");
            for (ResiduoModel residuo : getListaResiduos()) {
                sb.append(" - ").append(residuo.getNombre());
                sb.append("\n");
            }
        } else {
            sb.append("\nNo hay residuos en esta solicitud.\n");
        }

        sb.append("Productor: ").append(getProd().getUsuario());

        return sb.toString();
    }

}
