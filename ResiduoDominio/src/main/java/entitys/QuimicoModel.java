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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author PRIDE ANACONDA
 */
@Entity
@Table (name = "Quimico")
public class QuimicoModel implements Serializable {

    
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
    @Column(name="nombre")
    private String nombre;
    
    
    @ManyToMany (mappedBy = "listaQuimicos")
    private List<ResiduoModel> listaResiduos;
    
    /**
     * Default constructor
     */
    
    public QuimicoModel() {
        
    }
    public QuimicoModel(String nombre) {

        this.nombre = nombre;
    }

    public QuimicoModel(String nombre, List<ResiduoModel> listaResiduos) {
        this.nombre = nombre;
        this.listaResiduos = listaResiduos;
    }

 


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    public List<ResiduoModel> getListaResiduos() {
        return listaResiduos;
    }

    public void setListaResiduos(List<ResiduoModel> listaResiduos) {
        this.listaResiduos = listaResiduos;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    

    
}
