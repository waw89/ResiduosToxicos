/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PRIDE ANACONDA
 */
@Entity
public class SolicitudTrasladoModel implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Especificacion Residuos",
            joinColumns = @JoinColumn(name = "id_solicitud", referencedColumnName = "idSolicitud"),
            inverseJoinColumns = @JoinColumn (name = "id_residuo", referencedColumnName = "id_residuo")
    )
    private List<ResiduoModel> listaResiduos;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "IdTransportistas")
    private List<TransportistaModel> trans;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "IdProductor")
    private ProductorModel prod;


    /**
     * Default constructor
     */
    public SolicitudTrasladoModel() {
    }

    public SolicitudTrasladoModel(long id, Date fecha, float cantidadRes, boolean asignado, List<ResiduoModel> listaResiduos, List<TransportistaModel> trans, ProductorModel prod) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRes = cantidadRes;
        this.asignado = asignado;
        this.listaResiduos = listaResiduos;
        this.trans = trans;
        this.prod = prod;
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

    public List<ResiduoModel> getListaResiduos() {
        return listaResiduos;
    }

    public void setListaResiduos(List<ResiduoModel> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }

    public List<TransportistaModel> getTrans() {
        return trans;
    }

    public void setTrans(List<TransportistaModel> trans) {
        this.trans = trans;
    }

    public ProductorModel getProd() {
        return prod;
    }

    public void setProd(ProductorModel prod) {
        this.prod = prod;
    }

    public void agregaTransportista(TransportistaModel transportista) {
        trans.add(transportista);
    }

}
