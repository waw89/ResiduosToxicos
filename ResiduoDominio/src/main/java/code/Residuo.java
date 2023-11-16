/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="Residuo")
public class Residuo implements Serializable {
    /**
     * 
     */
    @Id 
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column (name = "Id_Residuo")
    private long id;

    /**
     * 
     */
    @Basic
    @Column(name="codigo")
    private String codigo;

    /**
     * 
     */
    @Basic
    @Column(name="nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn (name = "IdProductor")
    private Productor prod;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Residuo_Quimico",
            joinColumns = @JoinColumn(name = "id_Residuo"),
            inverseJoinColumns = @JoinColumn(name = "id_Quimico")
    )
    private List<Quimico> listaQuimicos;
    
    @ManyToMany (mappedBy = "listaResiduos")
    private List<SolicitudTraslado> listaSolTraslados;
    
    /**
     * Default constructor
     */
    public Residuo() {
    }

    public Residuo(String codigo, String nombre) {

        this.codigo = codigo;
        this.nombre = nombre;
    
    }

    public Residuo(long id, String codigo, String nombre, Productor prod, List<Quimico> listaQuimicos, List<SolicitudTraslado> listaSolTraslados) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.prod = prod;
        this.listaQuimicos = listaQuimicos;
        this.listaSolTraslados = listaSolTraslados;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Productor getProd() {
        return prod;
    }

    public void setProd(Productor prod) {
        this.prod = prod;
    }

    public List<Quimico> getListaQuimicos() {
        return listaQuimicos;
    }

    public void setListaQuimicos(List<Quimico> listaQuimicos) {
        this.listaQuimicos = listaQuimicos;
    }

    public List<SolicitudTraslado> getListaSolTraslados() {
        return listaSolTraslados;
    }

    public void setListaSolTraslados(List<SolicitudTraslado> listaSolTraslados) {
        this.listaSolTraslados = listaSolTraslados;
    }
    
}