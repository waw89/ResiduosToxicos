/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author PRIDE ANACONDA
 */
// Falta agregar Productor a esta clase y Solicitud de traslado
@Entity
@Table (name = "Residuo")
public class ResiduoModel implements Serializable {

 
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
    @Basic
    @Column(name="codigo")
    private Long codigo;

    /**
     * 
     */
    @Basic
    @Column(name="nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn (name = "IdProductor")
    private ProductorModel prod;

    @ManyToMany 
    @JoinTable(
            name = "Residuo_Quimico",
            joinColumns = @JoinColumn(name = "id_Residuo"),
            inverseJoinColumns = @JoinColumn(name = "id_Quimico")
    )
    private List<QuimicoModel> listaQuimicos;
    
    @ManyToMany (mappedBy = "listaResiduos")
    private List<SolicitudTrasladoModel> listaSolTraslados;
    
    /**
     * Default constructor
     */
    public ResiduoModel() {
    }

    public ResiduoModel(long codigo, String nombre) {

        this.codigo = codigo;
        this.nombre = nombre;
    
    }


    


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProductorModel getProd() {
        return prod;
    }

    public void setProd(ProductorModel prod) {
        this.prod = prod;
    }
    
    
}
