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
 *
 * @author PRIDE ANACONDA
 */
@Entity
@Table(name = "SolicitudTraslado")
public class SolicitudTrasladoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSolicitud")

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
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaTraslado")
    private Date fecha;

    /**
     *
     */
    @Basic
    @Column(name = "CantidadRes")
    private float cantidadRes;

    /**
     *
     */
    @Basic
    @Column(name = "Asignado")
    private boolean asignado;

    /**
     *
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Solicitud_Residuos",
            joinColumns = @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud"),
            inverseJoinColumns = @JoinColumn(name = "id_residuo", referencedColumnName = "id_residuo")
    )
    
    private List<ResiduoModel> listaResiduos;

//    /**
//     *
//     */
//    @ManyToOne
//    @JoinColumn(name = "IdTransportistas")
//    private List<TransportistaModel> trans;
    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "IdProductor")
    private ProductorModel prod;
    
    //Versión preeliminar
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Solicitud_Transportista",
            joinColumns = @JoinColumn(name = "idSolicitud"),
            inverseJoinColumns = @JoinColumn(name = "IdTransportista")
    )
    private List<TransportistaModel> transportistas;
    /////////
    
    
    /**
     * Default constructor
     */
    public SolicitudTrasladoModel() {
    }

    public SolicitudTrasladoModel(long id, LocalDate fecha, float cantidadRes, boolean asignado, List<ResiduoModel> listaResiduos, List<TransportistaModel> transportistas, ProductorModel prod) {
        this.id = id;
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());;
        this.cantidadRes = cantidadRes;
        this.asignado = asignado;
        this.listaResiduos = listaResiduos;
        this.transportistas = transportistas;
        this.prod = prod;
    }

    public LocalDate getFecha() {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
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

    public List<ResiduoModel> getListaResiduos() {
        return listaResiduos;
    }

    public void setListaResiduos(List<ResiduoModel> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }

    //versión preeliminar
    public List<TransportistaModel> getTransportistas() {
        return this.transportistas;
    }
    public void setTransportistas(List<TransportistaModel> transportistas) {
        this.transportistas = transportistas;
    }
    //////
    
    public ProductorModel getProd() {
        return prod;
    }

    public void setProd(ProductorModel prod) {
        this.prod = prod;
    }

//    public void agregaTransportista(TransportistaModel transportista) {
//        trans.add(transportista);
//    }
    
    /**
     * Método toString que muestra la fecha de la solicitud, la lista de los residuos en la solicitud y el 
     * productor que solicitó el traslado
     * @return la fecha de la solicitud del traslado, los residuos de la solicitud de traslado y el productor que
     * solicitó el traslado
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
